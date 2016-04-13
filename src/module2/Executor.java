package module2;

import java.util.List;

public interface Executor<T> {
    // Добавить таск на выполнние. Результат таска будет доступен через метод getValidResults().
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends T> task) throws TaskHasBeenAlreadyExecuted;

    // Добавить таск на выполнение и валидатор результата. Результат таска будет записан в ValidResults если validator.isValid вернет true для этого результата
    // Результат таска будет записан в InvalidResults если validator.isValid вернет false для этого результата
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends T> task, Validator<Task<? extends T>> validator) throws TaskHasBeenAlreadyExecuted;

    // Выполнить все добавленые таски
    void execute() throws Exception;

    // Получить валидные результаты. Бросает Эксепшн если не был вызван метод execute()
    List<T> getValidResults() throws Exception;

    // Получить невалидные результаты. Бросает Эксепшн если не был вызван метод execute()
    List<T> getInvalidResults() throws Exception;

}
