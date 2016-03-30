package module1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static module1.CollectionType.*;
import static module1.Operation.*;
import static module1.PerformanceEvaluator.*;

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
                        evaluate(ARRAY_LIST, ADD),
                        evaluate(ARRAY_LIST, GET),
                        evaluate(ARRAY_LIST, REMOVE),
                        evaluate(ARRAY_LIST, CONTAINS),
                        evaluate(ARRAY_LIST, POPULATE),
                        evaluate(ARRAY_LIST, LIST_ITERATOR_ADD),
                        evaluate(ARRAY_LIST, LIST_ITERATOR_REMOVE)));
                addSeparator();
                break;
            case LINKED_LIST:
                report.append(String.format(leftAlignFormat, "LinkedList",
                        evaluate(LINKED_LIST, ADD),
                        evaluate(LINKED_LIST, GET),
                        evaluate(LINKED_LIST, REMOVE),
                        evaluate(LINKED_LIST, CONTAINS),
                        evaluate(LINKED_LIST, POPULATE),
                        evaluate(LINKED_LIST, LIST_ITERATOR_ADD),
                        evaluate(LINKED_LIST, LIST_ITERATOR_REMOVE)));
                addSeparator();
                break;
            case HASH_SET:
                report.append(String.format(leftAlignFormat, "HashSet",
                        evaluate(HASH_SET, ADD),
                        "-",
                        evaluate(HASH_SET, REMOVE),
                        evaluate(HASH_SET, CONTAINS),
                        evaluate(HASH_SET, POPULATE),
                        "-",
                        "-"));
                addSeparator();
                break;
            case TREE_SET:
                report.append(String.format(leftAlignFormat, "TreeSet",
                        evaluate(TREE_SET, ADD),
                        "-",
                        evaluate(TREE_SET, REMOVE),
                        evaluate(TREE_SET, CONTAINS),
                        evaluate(TREE_SET, POPULATE),
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