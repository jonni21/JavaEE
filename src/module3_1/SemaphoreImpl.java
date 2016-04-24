package module3_1;

public class SemaphoreImpl implements Semaphore {
    private final Object lock = new Object();
    private int permitsMax = 4;
    private volatile int permitsAvailable = permitsMax;

    public SemaphoreImpl() {
    }

    public SemaphoreImpl(int permits) {
        permitsMax = permits;
    }

    @Override
    public void acquire() throws InterruptedException {
    }

    @Override
    public void acquire(int permits) {

    }

    @Override
    public void release() {

    }

    @Override
    public void release(int permits) {

    }

    @Override
    public int getAvailablePermits() {
        return permitsAvailable;
    }

    private void getLock(int permitsRequested) throws Exception {
        if (permitsRequested > permitsMax) {
            throw new IllegalArgumentException("Number of permits acquired exceed max permits number!");
        } else if (permitsAvailable >= permitsRequested) {
            permitsAvailable -= permitsRequested;
        } else {

        }
    }
}
