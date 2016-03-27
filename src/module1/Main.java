package module1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List arr = new ArrayList();
        List linkedList = new LinkedList();
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
        System.out.println(PerformanceEvaluator.evaluateAdd(new HashSet()));
        System.out.println(PerformanceEvaluator.evaluateAdd(new TreeSet()));

    }
}
