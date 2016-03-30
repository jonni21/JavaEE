package module1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReportGenerator {

    private static final StringBuilder report = new StringBuilder();
    private static final String leftAlignFormat = "|%-10s| %-8s | %-8s | %-8s | %-8s | %-8s | %-12s | %-15s |%n";

    public ReportGenerator() {
        report.append(String
                .format("+----------+----------+----------+----------+----------+----------+--------------+-----------------+%n"));
        report.append(String
                .format("|          | add      | get      | remove   | contains | populate | iterator.add | iterator.remove |%n"));
        report.append(String
                .format("+----------+----------+----------+----------+----------+----------+--------------+-----------------+%n"));
    }

    public void addRow(CollectionType collectionType) {
        switch (collectionType) {
            case ARRAY_LIST:
                report.append(String.format(leftAlignFormat, "ArrayList",
                        PerformanceEvaluator.evaluate(CollectionType.ARRAY_LIST, Operation.ADD),
                        PerformanceEvaluator.evaluate(CollectionType.ARRAY_LIST, Operation.GET),
                        PerformanceEvaluator.evaluate(CollectionType.ARRAY_LIST, Operation.REMOVE),
                        PerformanceEvaluator.evaluate(CollectionType.ARRAY_LIST, Operation.CONTAINS),
                        PerformanceEvaluator.evaluate(CollectionType.ARRAY_LIST, Operation.POPULATE),
                        PerformanceEvaluator.evaluate(CollectionType.ARRAY_LIST, Operation.LIST_ITERATOR_ADD),
                        PerformanceEvaluator.evaluate(CollectionType.ARRAY_LIST, Operation.LIST_ITERATOR_REMOVE)));
                addSeparator();
                break;
            case LINKED_LIST:
                report.append(String.format(leftAlignFormat, "LinkedList",
                        PerformanceEvaluator.evaluate(CollectionType.LINKED_LIST, Operation.ADD),
                        PerformanceEvaluator.evaluate(CollectionType.LINKED_LIST, Operation.GET),
                        PerformanceEvaluator.evaluate(CollectionType.LINKED_LIST, Operation.REMOVE),
                        PerformanceEvaluator.evaluate(CollectionType.LINKED_LIST, Operation.CONTAINS),
                        PerformanceEvaluator.evaluate(CollectionType.LINKED_LIST, Operation.POPULATE),
                        PerformanceEvaluator.evaluate(CollectionType.LINKED_LIST, Operation.LIST_ITERATOR_ADD),
                        PerformanceEvaluator.evaluate(CollectionType.LINKED_LIST, Operation.LIST_ITERATOR_REMOVE)));
                addSeparator();
                break;
            case HASH_SET:
                report.append(String.format(leftAlignFormat, "HashSet",
                        PerformanceEvaluator.evaluate(CollectionType.HASH_SET, Operation.ADD),
                        "-",
                        PerformanceEvaluator.evaluate(CollectionType.HASH_SET, Operation.REMOVE),
                        PerformanceEvaluator.evaluate(CollectionType.HASH_SET, Operation.CONTAINS),
                        PerformanceEvaluator.evaluate(CollectionType.HASH_SET, Operation.POPULATE),
                        "-",
                        "-"));
                addSeparator();
                break;
            case TREE_SET:
                report.append(String.format(leftAlignFormat, "TreeSet",
                        PerformanceEvaluator.evaluate(CollectionType.TREE_SET, Operation.ADD),
                        "-",
                        PerformanceEvaluator.evaluate(CollectionType.TREE_SET, Operation.REMOVE),
                        PerformanceEvaluator.evaluate(CollectionType.TREE_SET, Operation.CONTAINS),
                        PerformanceEvaluator.evaluate(CollectionType.TREE_SET, Operation.POPULATE),
                        "-",
                        "-"));
                addSeparator();
                break;
        }
    }

    public void printTable() {
        System.out.println(report.toString());
    }

    public void saveToFile(String fileName) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.print(report);
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found" + e.toString());
        }
    }

    private void addSeparator() {
        report.append(String
                .format("+----------+----------+----------+----------+----------+----------+--------------+-----------------+%n"));
    }
}