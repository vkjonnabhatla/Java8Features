package org.java8.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * List to Map
 */
public class FunctionFIListToMapExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Venkata","Krishna", "Macys", "technolgy");

        Function<String, Integer> function = x -> x.length();

        Map<String, Integer> result = map(list, String::length);//x -> x.length()
        System.out.println(result);
    }

    public static <T, R> Map<T, R> map(List<T> list, Function<T, R> function){

        Map<T, R> map = new HashMap<>();
        for(T str : list){
            map.put(str, function.apply(str));
        }
        return map;
    }
}
