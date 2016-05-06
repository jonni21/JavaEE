package module3_1;

public class SemaphoreImpl implements Semaphore {
    private int permissions = 0;
    private int bound = 0;

    public SemaphoreImpl(int bound) {
        this.bound = bound;
    }

    @Override
    public synchronized void acquire() throws InterruptedException {
        while (permissions >= bound) {
            wait();
        }
        permissions++;
        notifyAll();
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        while (permissions >= bound) {
            wait();
        }
        permissions += permits;
        notifyAll();
    }

    @Override
    public synchronized void release() throws InterruptedException {
        while (permissions == 0) {
            wait();
        }
        permissions--;
        notifyAll();
    }

    @Override
    public void release(int permits) throws InterruptedException {
        while (permissions == 0) {
            wait();
        }
        permissions -= permits;
        notifyAll();
    }

    @Override
    public int getAvailablePermits() {
        return bound - permissions;
    }
}