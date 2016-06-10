package module3_1;

public interface Semaphore {

    /**
     * Запрашивает разрешение. Если есть свободное захватывает его.
     * Если нет - приостанавливает поток до тех пор пока не появится
     * свободное разрешение.
     *
     * @throws InterruptedException
     */
    void acquire() throws InterruptedException;

    /**
     * Запрашивает переданое количество разрешений.
     * Если есть переданое количество свободных разрешений захватывает их.
     * Если нет - приостанавливает поток до тех пор пока не появится переданое
     * количество свободных разрешений.
     *
     * @param permits количество разрешений
     * @throws InterruptedException
     */
    void acquire(int permits) throws InterruptedException;

    /**
     * Отпускает разрешение возвращая его семафору.
     *
     * @throws InterruptedException
     */
    void release() throws InterruptedException;

    /**
     * Отпускает переданое количество разрешений возварщая их семафору.
     *
     * @param permits количество разрешений
     * @throws InterruptedException
     */
    void release(int permits) throws InterruptedException;

    /**
     * Возвращает количество свободных разрешений на данный момент.
     *
     * @return количество свободных разрешений
     */
    int getAvailablePermits();
}