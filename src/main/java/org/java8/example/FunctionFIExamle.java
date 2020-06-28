package org.java8.example;

import java.util.function.Function;

public class FunctionFIExamle {

    public static void main(String[] args) {

        Function<String, Integer> func = x -> x.length();

        Function<Integer, Integer> func1 = x -> x * 2;

        int result = func.andThen(func1).apply("macys");
        System.out.println(result);
    }
}
