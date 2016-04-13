package module2;

public interface Task<T> {
    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();
}
