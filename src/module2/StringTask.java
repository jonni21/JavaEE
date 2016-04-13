package module2;

public class StringTask implements Task<String> {
    private String message;
    private Integer length;

    public StringTask(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        length = message.length();
    }

    @Override
    public String getResult() {
        return length.toString();
    }
}
