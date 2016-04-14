package module2;

public class NumberValidator implements Validator<Task<? extends Number>> {
    //класс NumberValidator проверяет число на четность

    @Override
    public boolean isValid(Task<? extends Number> task) {
        //возвращает true, если число четное
        task.execute();
        return (task.getResult().longValue() & 1) == 0;
    }
}
