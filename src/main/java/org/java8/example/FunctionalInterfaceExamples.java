package org.java8.example;

import java.util.function.Function;

public class FunctionalInterfaceExamples {

    public static void main(String[] args) {
        Function<String, Integer> function = x -> { return x.length(); };

        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        int length = function.apply("Venkata");
        int innerClassLength = function1.apply("Krishna");
        System.out.println(length);
        System.out.println(innerClassLength);

    }
}
