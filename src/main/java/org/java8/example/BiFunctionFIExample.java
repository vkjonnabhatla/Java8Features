package org.java8.example;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * BiFunction chain with a function
 */
public class BiFunctionFIExample {
    public static void main1(String[] args) {

        BiFunction<Integer, Integer, Double> biFunction = (x1, x2) -> Math.pow(x1, x2);

        BiFunction<Integer, Integer, Double> biFunction1 = new BiFunction<Integer, Integer, Double>() {
            @Override
            public Double apply(Integer integer, Integer integer2) {
                return null;
            }
        };

        Function<Double, String>  function = x -> "String :: " + String.valueOf(x);

        System.out.println(biFunction.andThen(function).apply(2, 4));

    }

    public static void main(String[] args) {

        String str = convert(2, 3,
                (x1, x2) -> Math.pow(x1, x2),
                x -> "Result ::"+ String.valueOf(x));

        String str1 = convert("a", "b", (x1, x2) -> x1 + x2, x -> x + "cde");
        System.out.println(str);
    }

    public static <T, U, R, X> X convert(T x1, U x2, BiFunction<T, U, R> biFunction,
                                     Function<R, X> function){
         return biFunction.andThen(function).apply(x1, x2);
    }
}
