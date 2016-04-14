package module2.test;

import module2.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ExecutorImplTest {

    @Test(expected = Exception.class)
    public void testAddTask() throws Exception {
        Executor<Number> numberExecutor = new ExecutorImpl<>();
        numberExecutor.addTask(new IntTask(12));
        numberExecutor.addTask(new LongTask(45L));
        numberExecutor.execute();
        numberExecutor.addTask(new IntTask(55));
    }

    @Test(expected = TaskHasBeenAlreadyExecuted.class)
    public void testAddTask1() throws Exception {
        Executor<Number> numberExecutor = new ExecutorImpl<>();
        numberExecutor.addTask(new IntTask(24));
        numberExecutor.addTask(new LongTask(47L));
        numberExecutor.addTask(new IntTask(57), new NumberValidator());
        numberExecutor.execute();
        numberExecutor.addTask(new IntTask(75));
    }

    @Test(expected = Exception.class)
    public void testExecute() throws Exception {
        Executor<Number> numberExecutor = new ExecutorImpl<>();
        numberExecutor.addTask(new LongTask(2324234L));
        numberExecutor.addTask(new IntTask(234243534));
        numberExecutor.execute();
        numberExecutor.execute();
    }

    @Test
    public void testGetValidResults() throws Exception {
        List<Number> expectedNumber = Arrays.asList(10, 12, 14, 16, 18L, 20L, 22L, 24L);
        Executor<Number> executor = new ExecutorImpl<>();
        executor.addTask(new IntTask(10));
        executor.addTask(new IntTask(-11));
        executor.addTask(new IntTask(-12));
        executor.addTask(new IntTask(13));
        executor.addTask(new IntTask(14));
        executor.addTask(new IntTask(15));
        executor.addTask(new IntTask(16));
        executor.addTask(new LongTask(17L));
        executor.addTask(new LongTask(18L));
        executor.addTask(new LongTask(19L));
        executor.addTask(new LongTask(20L));
        executor.addTask(new LongTask(21L));
        executor.addTask(new LongTask(22L));
        executor.addTask(new LongTask(23L), new NumberValidator());
        executor.addTask(new LongTask(24L));
        executor.execute();
        List<Number> actualNumber = executor.getValidResults();
        assertThat(actualNumber, is(expectedNumber));

        List<String> expectedString = Arrays.asList("2", "4", "6");
        Executor<String> stringExecutor = new ExecutorImpl<>();
        stringExecutor.addTask(new StringTask("ab"));
        stringExecutor.addTask(new StringTask("abc"));
        stringExecutor.addTask(new StringTask("abcd"));
        stringExecutor.addTask(new StringTask("abcde"));
        stringExecutor.addTask(new StringTask("abcdef"));
        stringExecutor.addTask(new StringTask("abcdefg"), new StringValidator());
        stringExecutor.execute();
        List<String> actualString = stringExecutor.getValidResults();
        assertThat(actualString, is(expectedString));
    }

    @Test
    public void testGetInvalidResults() throws Exception {
        List<Number> expectedNumber = Arrays.asList(11, 13, 15, 17L, 19L, 21L, 23L);
        Executor<Number> executor = new ExecutorImpl<>();
        executor.addTask(new IntTask(10));
        executor.addTask(new IntTask(-11));
        executor.addTask(new IntTask(-12));
        executor.addTask(new IntTask(13));
        executor.addTask(new IntTask(14));
        executor.addTask(new IntTask(15));
        executor.addTask(new IntTask(16));
        executor.addTask(new LongTask(17L));
        executor.addTask(new LongTask(18L));
        executor.addTask(new LongTask(19L));
        executor.addTask(new LongTask(20L));
        executor.addTask(new LongTask(21L));
        executor.addTask(new LongTask(22L));
        executor.addTask(new LongTask(23L), new NumberValidator());
        executor.addTask(new LongTask(24L));
        executor.execute();
        List<Number> actualNumber = executor.getInvalidResults();
        assertThat(actualNumber, is(expectedNumber));

        List<String> expectedString = Arrays.asList("3", "5", "7");
        Executor<String> stringExecutor = new ExecutorImpl<>();
        stringExecutor.addTask(new StringTask("ab"));
        stringExecutor.addTask(new StringTask("abc"));
        stringExecutor.addTask(new StringTask("abcd"));
        stringExecutor.addTask(new StringTask("abcde"));
        stringExecutor.addTask(new StringTask("abcdef"));
        stringExecutor.addTask(new StringTask("abcdefg"), new StringValidator());
        stringExecutor.execute();
        List<String> actualString = stringExecutor.getInvalidResults();
        assertThat(actualString, is(expectedString));
    }
}