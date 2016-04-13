package module2;

public class LongTask implements Task<Long> {
    private long aLong;

    public LongTask(long aLong) {
        this.aLong = aLong;
    }

    @Override
    public void execute() {
        aLong = Math.abs(aLong);
    }

    @Override
    public Long getResult() {
        return aLong;
    }
}
