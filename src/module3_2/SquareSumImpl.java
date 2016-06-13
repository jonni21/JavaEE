package module3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Класс SquareSumImpl считает сумму квадратов элементов массива
 * в заданном количестве потоков.
 */
public class SquareSumImpl implements SquareSum {

    /**
     * Принимает целочисленный массив и возвращает сумму квадратов его элементов.
     * Вычисления производятся в заданном количестве потоков.
     *
     * @param values          целочисленный массив с исходными данными
     * @param numberOfThreads количество потоков, в которых выполняются вычисления
     * @return сумма квадратов массива, значиние типа <code>long</code>
     */
    @Override
    public long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException {
        List<Callable<Long>> tasks = new ArrayList<>();
        Phaser phaser = new Phaser();
        int length = values.length;
        int threads = numberOfThreads;
        int startPosition = 0;
        int step;
        long sum = 0L;

        if (values.length == 0 || numberOfThreads <= 0) return 0L;

        if (values.length < numberOfThreads) numberOfThreads = values.length;

        for (int i = 0; i < numberOfThreads; i++) {
            phaser.register();
            step = getStep(length, threads--);
            length -= step;
            tasks.add(new Task(values, step, startPosition, phaser));
            startPosition += step;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<Long>> results = executorService.invokeAll(tasks);

        for (Future<Long> result : results) {
            sum += result.get();
            phaser.arriveAndDeregister();
        }
        executorService.shutdown();
        return sum;
    }

    private int getStep(int length, int threads) {
        if (length % threads > 0) {
            return length / threads + 1;
        } else {
            return length / threads;
        }
    }

    class Task implements Callable<Long> {
        Phaser phaser;
        final int[] values;
        final int step;
        final int startPosition;
        long result = 0L;

        public Task(int[] values, int step, int startPosition, Phaser phaser) {
            this.values = values;
            this.step = step;
            this.startPosition = startPosition;
            this.phaser = phaser;
        }

        @Override
        public Long call() throws Exception {
            for (int i = startPosition; i < startPosition + step; i++) {
                result += values[i] * values[i];
            }
            phaser.arrive();
            return result;
        }
    }
}