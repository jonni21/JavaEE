package module3_1;

public class SemaphoreImpl implements Semaphore {
    private final Object lock = new Object();
    private int permitsMax = 4;
    private int permitsAvailable = permitsMax;

    public SemaphoreImpl() {
    }

    public SemaphoreImpl(int permits) {
        permitsMax = permits;
    }

    @Override
    public void acquire() throws Exception {
        getLock(1);
    }

    @Override
    public void acquire(int permits) throws Exception {
        getLock(permits);
    }

    @Override
    public void release() {
        synchronized (lock) {
            permitsAvailable += 1;
            lock.notifyAll();
        }
    }

    @Override
    public void release(int permits) {
        synchronized (lock) {
            permitsAvailable += permits;
            lock.notifyAll();
        }
    }

    @Override
    public int getAvailablePermits() {
        return permitsAvailable;
    }

    private void getLock(int permitsRequested) throws Exception {
        synchronized (lock) {
            if (permitsRequested > permitsMax) {
                throw new IllegalArgumentException("Number of permits acquired exceed max permits number!");
            } else if (permitsAvailable >= permitsRequested) {
                permitsAvailable -= permitsRequested;
            } else {
                lock.wait();
            }
        }
    }
}
