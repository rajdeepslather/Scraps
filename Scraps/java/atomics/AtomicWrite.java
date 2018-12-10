package atomics;

import java.lang.reflect.Array;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 *
 * This is faster than AtomicReference in many cases. Do not use this with
 * mutable objects, use AtomicReadWrite for that instead.
 * 
 * @author RAJDEEP
 * @param <V>
 */
public class AtomicWrite<V> {

	private volatile V value;
	private final Object monitor = new Object();

	public AtomicWrite() {

	}

	public AtomicWrite(final V value) {
		this.value = value;
	}

	/**
	 * Use this object for synchronizing
	 * 
	 * @return monitor
	 */
	public Object getMonitor() {
		return this.monitor;
	}

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
	 * Atomically sets to the given value and returns the previous value.
	 * 
	 * @param newValue
	 *            the new value
	 * @return the previous value
	 */
	public V getAndSet(final V newValue) {
		synchronized (this.monitor) {
			final V prev = this.value;
			this.value = newValue;
			return prev;
		}
	}

	/**
	 * Atomically updates the current value with the new one from the given supplier
	 * and returns the previous value
	 * 
	 * @param supplier
	 * @return the previous value
	 */
	public V getAndUpdate(final Supplier<V> supplier) {
		synchronized (this.monitor) {
			final V prev = this.value;
			this.value = supplier.get();
			return prev;
		}
	}

	/**
	 * Atomically updates the current value with the new one from the given supplier
	 * and returns the updated value
	 * 
	 * @param supplier
	 * @return the updated value
	 */
	public V updateAndGet(final Supplier<V> supplier) {
		synchronized (this.monitor) {
			this.value = supplier.get();
			return this.value;
		}
	}

	/**
	 * Calls the Callable in synchronized block and returns the result of Callable
	 * 
	 * @param callable
	 * @return the result of Callable
	 * @throws Exception
	 */
	public <T> T callWithSync(final Callable<T> callable) throws Exception {
		synchronized (this.monitor) {
			return callable.call();
		}
	}

	@SuppressWarnings("unchecked")
	public static <V> AtomicWrite<V>[] builAsArray(final int capacity) {
		return (AtomicWrite<V>[]) Array.newInstance(new AtomicWrite<V>().getClass(), capacity);
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}
