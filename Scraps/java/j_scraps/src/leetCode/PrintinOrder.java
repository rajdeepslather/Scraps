package leetCode;

class PrintinOrder {
    CountDownLatch firstLatch = new CountDownLatch(1);
    CountDownLatch secondLatch = new CountDownLatch(1);

    public PrintinOrder() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstLatch.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondLatch.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
