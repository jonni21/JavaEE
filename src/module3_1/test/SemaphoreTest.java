package module3_1.test;

import module3_1.SemaphoreImpl;

public class SemaphoreTest {

    SemaphoreImpl semaphore = new SemaphoreImpl(5);

    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new AcquiringWorker()).start();
        }

        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            new Thread(new ReleasingWorker()).start();
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " released 2 slots.");
                try {
                    semaphore.release(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    class AcquiringWorker implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " requested 2 slots.");
                semaphore.acquire(2);
                System.out.println("Thread " + Thread.currentThread().getName() + " got 2 slots.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ReleasingWorker implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " released 2 slots.");
                semaphore.release(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        try {
            semaphoreTest.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}