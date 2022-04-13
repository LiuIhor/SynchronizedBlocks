package exampleTaskWithPhone;

public class Example {

    static final Phone lock = new Phone();
    static final Object lock2 = new Object();

    void mobileCall() {
        System.out.println(this);
        synchronized (lock2){
        System.out.println("Mobile call starts");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Mobile call ends");
        }
    }

    void skypeCall() {
        System.out.println(lock);
        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }

    void viberCall() {
        System.out.println(this);
        synchronized (lock) {
            System.out.println("Viber call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Viber call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplSkype());
        Thread thread3 = new Thread(new RunnableImplViber());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImplMobile implements Runnable {

    @Override
    public void run() {
        new Example().mobileCall();
    }
}

class RunnableImplSkype implements Runnable {

    @Override
    public void run() {
        new Example().skypeCall();
    }
}

class RunnableImplViber implements Runnable {

    @Override
    public void run() {
        new Example().viberCall();
    }
}

class Phone{}
