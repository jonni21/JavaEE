package module1;

import java.util.*;

class PerformanceEvaluator {
    private static final int[] COLLECTION_SIZE = {10_000, 100_000, 1_000_000};
    private static final int NUM_OF_REPETITIONS = 100;
    private static final Random randomGenerator = new Random();
    private static long sum = 0;
    private static long average = 0;

    public static long evaluateAdd(List list) {
        for (int i : COLLECTION_SIZE) {
            init(list, i);

            for (int k = 0; k < NUM_OF_REPETITIONS; k++) {
                int randomInt = randomGenerator.nextInt(i);
                long start = System.nanoTime();
                list.add(randomInt, randomInt);
                sum += System.nanoTime() - start;
            }
            average += sum / NUM_OF_REPETITIONS;
            sum = 0;
        }

        return average / COLLECTION_SIZE.length;
    }

    public static long evaluateAdd(Set set) {
        for (int i : COLLECTION_SIZE) {
            init(set, i);

            for (int k = 0; k < NUM_OF_REPETITIONS; k++) {
                int randomInt = randomGenerator.nextInt(i);
                long start = System.nanoTime();
                set.add(randomInt);
                sum += System.nanoTime() - start;
            }
            average += sum / NUM_OF_REPETITIONS;
            sum = 0;
        }
        return average / COLLECTION_SIZE.length;
    }

    public static long evaluateGet(List list) {
        for (int i : COLLECTION_SIZE) {
            init(list, i);

            for (int k = 0; k < NUM_OF_REPETITIONS; k++) {
                int randomInt = randomGenerator.nextInt(i);
                long start = System.nanoTime();
                list.get(randomInt);
                sum += System.nanoTime() - start;
            }
            average += sum / NUM_OF_REPETITIONS;
            sum = 0;
        }

        return average / COLLECTION_SIZE.length;
    }

    public static long evaluateRemove(List list) {
        for (int i : COLLECTION_SIZE) {
            init(list, i);

            for (int k = 0; k < NUM_OF_REPETITIONS; k++) {
                int randomInt = randomGenerator.nextInt(i);
                long start = System.nanoTime();
                list.remove(randomInt);
                sum += System.nanoTime() - start;
            }
            average += sum / NUM_OF_REPETITIONS;
            sum = 0;
        }

        return average / COLLECTION_SIZE.length;
    }

    public static long evaluateContains(List list) {
        for (int i : COLLECTION_SIZE) {
            init(list, i);

            for (int k = 0; k < NUM_OF_REPETITIONS; k++) {
                int randomInt = randomGenerator.nextInt(i);
                long start = System.nanoTime();
                list.contains(randomInt);
                sum += System.nanoTime() - start;
            }
            average += sum / NUM_OF_REPETITIONS;
            sum = 0;
        }

        return average / COLLECTION_SIZE.length;
    }

    public static long evaluatePopulate(List list) {
        for (int i : COLLECTION_SIZE) {

            for (int k = 0; k < NUM_OF_REPETITIONS; k++) {
                long start = System.nanoTime();
                init(list, i);
                sum += System.nanoTime() - start;
            }
            average += sum / NUM_OF_REPETITIONS;
            sum = 0;
        }

        return average / COLLECTION_SIZE.length;
    }

    public static long evaluateIteratorAdd(List list) {
        for (int i : COLLECTION_SIZE) {
            init(list, i);
            ListIterator listIterator = list.listIterator();

            for (int k = 0; k < NUM_OF_REPETITIONS; k++) {
                long start = System.nanoTime();
                listIterator.add(k);
                sum += System.nanoTime() - start;
            }
            average += sum / NUM_OF_REPETITIONS;
            sum = 0;
        }

        return average / COLLECTION_SIZE.length;
    }

    public static long evaluateIteratorRemove(List list) {
        for (int i : COLLECTION_SIZE) {
            init(list, i);
            ListIterator listIterator = list.listIterator();

            for (int k = 0; k < NUM_OF_REPETITIONS; k++) {
                listIterator.next();
                long start = System.nanoTime();
                listIterator.remove();
                sum += System.nanoTime() - start;
            }
            average += sum / NUM_OF_REPETITIONS;
            sum = 0;
        }

        return average / COLLECTION_SIZE.length;
    }

    private static void init(Collection c, int size) {
        c.clear();

        for (int i = 0; i < size; i++) {
            c.add(i);
        }
    }
}
