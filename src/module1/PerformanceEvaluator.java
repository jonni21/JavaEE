package module1;

import java.util.*;

class PerformanceEvaluator {
    private static final int[] COLLECTION_SIZE = {10_000, 100_000, 1_000_000};
    private static final int NUM_OF_REPETITIONS = 100;
    private static final Random randomGenerator = new Random();
    private static long sum = 0;
    private static long average = 0;

    public static long evaluate(CollectionType collectionType, Operation operation) {
        long sum = 0;

        for (int i : COLLECTION_SIZE) {
            switch (collectionType) {
                case ARRAY_LIST:
                    ArrayList arrayList = (ArrayList) init(new ArrayList(), i);
                    sum += calculatePerformance(arrayList, operation, i);
                    break;
                case LINKED_LIST:
                    LinkedList linkedList = (LinkedList) init(new LinkedList(), i);
                    sum += calculatePerformance(linkedList, operation, i);
                    break;
                case HASH_SET:
                    HashSet hashSet = (HashSet) init(new HashSet(), i);
                    sum += calculatePerformance(hashSet, operation, i);
                    break;
                case TREE_SET:
                    TreeSet treeSet = (TreeSet) init(new TreeSet(), i);
                    sum += calculatePerformance(treeSet, operation, i);
                    break;
            }
        }
        return sum / COLLECTION_SIZE.length;
    }

    private static long calculatePerformance(Collection collection, Operation operation, int collectionSize) {
        long sum = 0;

        for (int i = 0; i < NUM_OF_REPETITIONS; i++) {
            int randomInt = randomGenerator.nextInt(collectionSize);
            switch (operation) {
                case ADD:
                    if (collection.getClass().getSimpleName().equals("ArrayList")) {
                        ArrayList arrayList = (ArrayList) collection;
                        long start = System.nanoTime();
                        arrayList.add(randomInt, randomInt);
                        sum += System.nanoTime() - start;
                    } else if (collection.getClass().getSimpleName().equals("LinkedList")) {
                        LinkedList linkedList = (LinkedList) collection;
                        long start = System.nanoTime();
                        linkedList.add(randomInt, randomInt);
                        sum += System.nanoTime() - start;
                    } else {
                        long start = System.nanoTime();
                        collection.add(randomInt);
                        sum += System.nanoTime() - start;
                    }
                    break;
                case GET:
                    break;
                case REMOVE:
                    break;
                case CONTAINS:
                    break;
                case POPULATE:
                    break;
                case ITERATOR_ADD:
                    break;
                case ITERATOR_REMOVE:
                    break;
            }
        }
        return sum / NUM_OF_REPETITIONS;
    }


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

    public static long evaluateRemove(Set set) {
        for (int i : COLLECTION_SIZE) {
            init(set, i);

            for (int k = 0; k < NUM_OF_REPETITIONS; k++) {
                int randomInt = randomGenerator.nextInt(i);
                long start = System.nanoTime();
                set.remove(randomInt);
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

    private static Collection init(Collection c, int size) {
        c.clear();

        for (int i = 0; i < size; i++) {
            c.add(i);
        }
        return c;
    }
}
