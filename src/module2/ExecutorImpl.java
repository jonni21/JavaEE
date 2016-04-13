package module2;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<T> implements Executor<T> {
    private List<Task<? extends T>> tasks = new ArrayList<>();
    private List<T> validResults = new ArrayList<>();
    private List<T> invalidResults = new ArrayList<>();
    private Validator<Task<? extends T>> validator;
    private boolean isExecuted = false;

    @Override
    public void addTask(Task<? extends T> task) throws TaskHasBeenAlreadyExecuted {
        if (isExecuted) {
            throw new TaskHasBeenAlreadyExecuted("Tasks has been already executed!");
        }
        tasks.add(task);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<Task<? extends T>> validator) throws TaskHasBeenAlreadyExecuted {
        if (isExecuted) {
            throw new TaskHasBeenAlreadyExecuted("Tasks has been already executed!");
        }
        tasks.add(task);
        this.validator = validator;
    }

    @Override
    public void execute() throws Exception {
        if (isExecuted) {
            throw new TaskHasBeenAlreadyExecuted("Tasks has been already executed!");
        }

        if (validator == null) {
            throw new Exception("Validator hasn't been initialized!");
        }

        for (Task task : tasks) {
            if (validator.isValid(task)) {
                validResults.add((T) task.getResult());
            } else {
                invalidResults.add((T) task.getResult());
            }
        }
        isExecuted = true;
    }

    @Override
    public List<T> getValidResults() throws Exception {
        if (!isExecuted) {
            throw new Exception("Tasks have never been executed!");
        }
        return validResults;
    }

    @Override
    public List<T> getInvalidResults() throws Exception{
        if (!isExecuted) {
            throw new Exception("Tasks have never been executed!");
        }
        return invalidResults;
    }
}