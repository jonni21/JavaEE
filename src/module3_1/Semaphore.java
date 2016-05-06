package module3_1;

public interface Semaphore {

    void acquire() throws InterruptedException;
    // Запрашивает разрешение. Если есть свободное захватывает его. Если нет - приостанавливает поток до тех пор пока
    // не появится свободное разрешение.

    void acquire(int permits) throws InterruptedException;
    // Запрашивает переданое количество разрешений. Если есть переданое количество свободных разрешений захватывает их.
    // Если нет - приостанавливает поток до тех пор пока не появится переданое колтчество свободных разрешений.

    void release() throws InterruptedException;
    // Отпускает разрешение возвращая его семафору.

    void release(int permits) throws InterruptedException;
    // Отпускает переданое количество разрешений возварщая их семафору.

    int getAvailablePermits();
    // Возвращает количество свободных разрешений на данный момент.
}