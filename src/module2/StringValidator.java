package module2;

public class StringValidator implements Validator<Task<String>> {
    //проверяет длину строки на валидность

    @Override
    public boolean isValid(Task<String> task) {
        //возвращает true, если длина строки - четное число
        task.execute();
        return (new Integer(task.getResult()) % 2) == 0;
    }
}
