package module1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ReportGenerator rp = new ReportGenerator();
        rp.addRow(CollectionType.ARRAY_LIST);
        rp.addRow(CollectionType.LINKED_LIST);
        rp.addRow(CollectionType.HASH_SET);
        rp.addRow(CollectionType.TREE_SET);
        rp.saveToFile("report.txt");
//        rp.printTable();

//        System.out.println(PerformanceEvaluator.evaluate(CollectionType.ARRAY_LIST, Operation.ADD));
//        System.out.println(PerformanceEvaluator.evaluate(CollectionType.LINKED_LIST, Operation.ADD));
//        System.out.println(PerformanceEvaluator.evaluate(CollectionType.ARRAY_LIST, Operation.GET));
//        System.out.println(PerformanceEvaluator.evaluate(CollectionType.LINKED_LIST, Operation.GET));



//        System.out.println(PerformanceEvaluator.evaluateAdd(new ArrayList()));
//        System.out.println(PerformanceEvaluator.evaluateAdd(new LinkedList()));
//        System.out.println(PerformanceEvaluator.evaluateGet(new ArrayList()));
//        System.out.println(PerformanceEvaluator.evaluateGet(new LinkedList()));
//        System.out.println(PerformanceEvaluator.evaluatePopulate(new ArrayList<>()));
//        System.out.println(PerformanceEvaluator.evaluatePopulate(new LinkedList<>()));
//        System.out.println(PerformanceEvaluator.evaluateIteratorAdd(new ArrayList<>()));
//        System.out.println(PerformanceEvaluator.evaluateIteratorAdd(new LinkedList<>()));
//        System.out.println(PerformanceEvaluator.evaluateIteratorRemove(new ArrayList<>()));
//        System.out.println(PerformanceEvaluator.evaluateIteratorRemove(new LinkedList<>()));
//        System.out.println(PerformanceEvaluator.evaluateAdd(new HashSet()));
//        System.out.println(PerformanceEvaluator.evaluateAdd(new TreeSet()));

    }
}
