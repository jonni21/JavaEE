package module2;

public class IntTask implements Task<Integer> {
    private int integer;

    public IntTask(Integer integer) {
        this.integer = integer;
    }

    @Override
    public void execute() {
        integer = Math.abs(integer);
    }

    @Override
    public Integer getResult() {
        return integer;
    }
}
