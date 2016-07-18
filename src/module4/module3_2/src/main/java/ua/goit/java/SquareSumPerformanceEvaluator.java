package ua.goit.java;

import module3_2.SquareSumImpl;

import java.util.concurrent.ExecutionException;

public class SquareSumPerformanceEvaluator {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] intArray = new int[200_000_000];
        long time = System.currentTimeMillis();
        System.out.println("Start array filling");

        for (int i = 1; i <= 200_000_000; i++) {
            intArray[i - 1] = i;
        }

        System.out.println("Stop array filling");
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - time));

        module3_2.SquareSumImpl squareSumImpl = new SquareSumImpl();
        System.out.println("Starting calculation");
        time = System.currentTimeMillis();
        System.out.println(squareSumImpl.getSquareSum(intArray, 1));
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - time));
        System.out.println("----------------------------");
        time = System.currentTimeMillis();
        System.out.println(squareSumImpl.getSquareSum(intArray, 2));
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - time));
        System.out.println("----------------------------");
        time = System.currentTimeMillis();
        System.out.println(squareSumImpl.getSquareSum(intArray, 6));
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - time));
        System.gc();
    }
}