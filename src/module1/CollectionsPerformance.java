package module1;

public class CollectionsPerformance {

    private static final StringBuilder resultTable = new StringBuilder();

//    enum Columns {
//        ADD {
//            public long getAverage(List list) {
//                int sum = 0;
//                long start;
//
//                for (int i = 0; i < NUM_OF_CALCULATIONS; i++) {
//                    start = System.nanoTime();
//                    list.add(i, i);
//                    sum += System.nanoTime() - start;
//                }
//                return sum / NUM_OF_CALCULATIONS;
//            }
//        }, GET, REMOVE, CONTAINS, POPULATE, ITERATOR_ADD, ITERATOR_REMOVE {};
//
//        private final static int NUM_OF_CALCULATIONS = 200;
//        }

    public CollectionsPerformance() {
        resultTable.append(String
                .format("+----------+----------+----------+----------+----------+----------+--------------+-----------------+%n"));
        resultTable.append(String
                .format("|          | add      | get      | remove   | contains | populate | iterator.add | iterator.remove |%n"));
        resultTable.append(String
                .format("+----------+----------+----------+----------+----------+----------+--------------+-----------------+%n"));
    }

    public String printTable() {
        return resultTable.toString();
    }

    private void saveToTable(String s) {
    }
}
