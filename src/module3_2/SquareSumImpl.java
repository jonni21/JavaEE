package module3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Класс SquareSumImpl считает сумму квадратов элементов массива
 * в заданном количестве потоков.
 */
public class SquareSumImpl implements SquareSum {
    private volatile int stepStartPosition = 0;
    private volatile int arrayLength;
    private volatile int threadsQuantity;
    private final Object lock = new Object();

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
        arrayLength = values.length;
        threadsQuantity = numberOfThreads;
        long sum = 0;

        if (values.length == 0) return 0L;

        if (values.length < numberOfThreads) numberOfThreads = values.length;

        for (int i = 0; i < numberOfThreads; i++) {
            Callable<Long> task = () -> {
                System.out.println(Thread.currentThread().getName() + " starts working.");
                long sum1 = 0L;
                int cutBegin = stepStartPosition;
                int cutEnd;
                synchronized (lock) {
                    int step = getStep(arrayLength, threadsQuantity);
                    arrayLength -= step;
                    threadsQuantity--;
                    cutEnd = cutBegin + step;
                    stepStartPosition += step;
                }

                while (cutBegin < cutEnd) {
                    sum1 += values[cutBegin] * values[cutBegin];
                    cutBegin++;
                }
                System.out.println(Thread.currentThread().getName() + " got result " + sum1);
                return sum1;
            };
            tasks.add(task);
        }

        stepStartPosition = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<Long>> results = executorService.invokeAll(tasks);

        for (Future<Long> result : results) {
            sum += result.get();
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
}