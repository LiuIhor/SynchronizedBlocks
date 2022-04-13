package synchronizedBlocks;

public class SynchronizedBlock1 {
    public static void main(String[] args) {
        MyRunnableImpl runnable = new MyRunnableImpl();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter {
    static int count = 0;
}

class MyRunnableImpl implements Runnable {

    public void doWork() {
        System.out.println(Thread.currentThread().getName() + " Ura!!!");
    }
    public void increment() {
        doWork();
        synchronized (this) {
            Counter.count++;
            System.out.println(Thread.currentThread().getName() + " " + Counter.count);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}
