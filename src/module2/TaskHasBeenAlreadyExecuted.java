package module2;

public class TaskHasBeenAlreadyExecuted extends Exception {
    public TaskHasBeenAlreadyExecuted(String message) {
        super(message);
    }
}

