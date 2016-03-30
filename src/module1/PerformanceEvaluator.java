package module1;

import java.util.*;

class PerformanceEvaluator {
    private static final int[] COLLECTION_SIZE = {10_000, 100_000, 1_000_000};
    private static final int NUM_OF_REPETITIONS = 100;
    private static final Random randomGenerator = new Random();

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
        long start;

        for (int i = 0; i < NUM_OF_REPETITIONS; i++) {
            int randomInt = randomGenerator.nextInt(collectionSize);

            switch (operation) {
                case ADD:
                    if (collection.getClass().getSimpleName().equals("ArrayList") ||
                            collection.getClass().getSimpleName().equals("LinkedList")) {
                        start = System.nanoTime();
                        ((List) collection).add(randomInt, randomInt);
                        sum += System.nanoTime() - start;
                    } else {
                        start = System.nanoTime();
                        collection.add(randomInt);
                        sum += System.nanoTime() - start;
                    }
                    break;
                case GET:
                    start = System.nanoTime();
                    ((List) collection).get(randomInt);
                    sum += System.nanoTime() - start;
                    break;
                case REMOVE:
                    start = System.nanoTime();
                    collection.remove(randomInt);
                    sum += System.nanoTime() - start;
                    break;
                case CONTAINS:
                    start = System.nanoTime();
                    collection.contains(randomInt);
                    sum += System.nanoTime() - start;
                    break;
                case POPULATE:
                    start = System.nanoTime();
                    init(collection, collectionSize);
                    sum += System.nanoTime() - start;
                    break;
                case LIST_ITERATOR_ADD:
                    ListIterator listIterator = ((List) collection).listIterator();
                    start = System.nanoTime();
                    listIterator.add(randomInt);
                    sum += System.nanoTime() - start;
                    break;
                case LIST_ITERATOR_REMOVE:
                    listIterator = ((List) collection).listIterator();
                    listIterator.next();
                    start = System.nanoTime();
                    listIterator.remove();
                    sum += System.nanoTime() - start;
                    break;
            }
        }
        return sum / NUM_OF_REPETITIONS;
    }

    private static Collection init(Collection c, int size) {
        c.clear();

        for (int i = 0; i < size; i++) {
            c.add(i);
        }
        return c;
    }
}