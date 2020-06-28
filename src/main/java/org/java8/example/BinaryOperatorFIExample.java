package org.java8.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorFIExample {
    public static void main(String[] args) {
       Integer[] numbers = {1, 2, 3};
       BinaryOperator<Integer> accumulator = (x1, x2) -> x1 + x2;
       Integer result = math(Arrays.asList(numbers), 0, (x1, x2) -> x1 + x2);
       System.out.println(result);

       Integer result1 = math(Arrays.asList(numbers), 0, Integer::sum);
       System.out.println(result1);
    }

    public static <T> T math(List<T> list, T init, BinaryOperator<T> accumulator){
        T result = init;
        for(T t : list){
            result = accumulator.apply(t, result);
        }
        return result;
    }
}
