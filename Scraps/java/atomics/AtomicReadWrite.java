package atomics;

import java.lang.reflect.Array;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * Can be used with mutable objects.
 * 
 * @author RAJDEEP
 * @param <V>
 */
public class AtomicReadWrite<V> {

	private V value;
	private final StampedLock stampedLock = new StampedLock();

	public AtomicReadWrite() {

	}

	public AtomicReadWrite(final V value) {
		this.value = value;
	}

	public Object getLock() {
		return this.stampedLock;
	}

	/**
	 * This is Not thread safe!
	 * 
	 * @return value
	 */
	public V get() {
		return this.value;
	}

	/**
	 * This is Not thread safe!
	 * 
	 * @param value
	 */
	public void set(final V value) {
		this.value = value;
	}

	/**
	 * Calls callable with Optimistic Lock, returns the result of Callable. Lock is
	 * Not Reentrant.
	 * 
	 * @param maxRetries
	 * @param callable
	 * @return result of callable
	 * @throws Exception
	 */
	public <T> T callWithOptimisticLock(final int maxRetries, final Callable<T> callable) throws Exception {
		final long OptimisticStamp = this.stampedLock.tryOptimisticRead();
		int tries = 1;
		T t;
		do {
			if (tries > maxRetries)
				return callWithReadLock(callable);
			else {
				t = callable.call();
				tries++;
			}
		} while (!this.stampedLock.validate(OptimisticStamp));
		return t;
	}

	/**
	 * Calls callable with Read Lock, returns the result of Callable. Lock is Not
	 * Reentrant.
	 * 
	 * @param callable
	 * @return result of callable
	 * @throws Exception
	 */
	public <T> T callWithReadLock(final Callable<T> callable) throws Exception {
		final long readStamp = this.stampedLock.readLock();
		try {
			return callable.call();
		} finally {
			this.stampedLock.unlockRead(readStamp);
		}
	}

	/**
	 * Calls callable with Write Lock, returns the result of Callable. Lock is Not
	 * Reentrant.
	 * 
	 * @param callable
	 * @return result of callable
	 * @throws Exception
	 */
	public <T> T callWithWriteLock(final Callable<T> callable) throws Exception {
		final long writeStamp = this.stampedLock.writeLock();
		try {
			return callable.call();
		} finally {
			this.stampedLock.unlockWrite(writeStamp);
		}
	}

	/**
	 * Calls readAndCall with Read Lock, then if isUpdatable tests true update will
	 * be used to update the value. In either case it will return the result of
	 * readAndCall and readAndCall will be tried again. readAndCall maybe called
	 * twice, ensure that the side effects are not present. Lock is Not Reentrant.
	 * 
	 * @param readAndCall
	 * @param isUpdatable
	 * @param update
	 * @return result of readAndCall
	 * @throws Exception
	 */
	public <T> T callAndUpdate(final Callable<T> readAndCall, final Predicate<T> isUpdatable,
			final Function<T, V> update) throws Exception {
		long stamp = this.stampedLock.readLock();
		try {
			while (true) {
				final T t = readAndCall.call();
				if (isUpdatable.test(t)) {
					final long writeTryStamp = this.stampedLock.tryConvertToWriteLock(stamp);
					if (writeTryStamp != 0L) {
						stamp = writeTryStamp;
						this.value = update.apply(t);
						return t;
					} else {
						this.stampedLock.unlockRead(stamp);
						stamp = this.stampedLock.writeLock();
					}
				} else
					return t;
			}
		} finally {
			this.stampedLock.unlock(stamp);
		}
	}

	/**
	 * Tries to call tryCall with Read Lock, then if an Exception is caught supplier
	 * will be used to update the value and tryCall will be tried again. In either
	 * case it will return the result of tryCall. tryCall maybe called twice, ensure
	 * that the side effects are not present. Lock is Not Reentrant.
	 * 
	 * @param tryCall
	 * @param supplier
	 * @return
	 * @throws Exception
	 */
	public <T> T tryCallUpdate(final Callable<T> tryCall, final Supplier<V> supplier) throws Exception {
		long stamp = this.stampedLock.readLock();
		try {
			while (true) {
				try {
					return tryCall.call();
				} catch (final Exception e) {
					// TODO do not hide the exception
					final long writeTryStamp = this.stampedLock.tryConvertToWriteLock(stamp);
					if (writeTryStamp != 0L) {
						stamp = writeTryStamp;
						this.value = supplier.get();
						return tryCall.call();
					} else {
						this.stampedLock.unlockRead(stamp);
						stamp = this.stampedLock.writeLock();
					}
				}
			}
		} finally {
			this.stampedLock.unlockRead(stamp);
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> AtomicReadWrite<V>[] builAsArray(final int capacity) {
		return (AtomicReadWrite<V>[]) Array.newInstance(new AtomicReadWrite<V>().getClass(), capacity);
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}
