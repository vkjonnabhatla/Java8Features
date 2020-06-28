package org.java8.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionFIFilterListExamples {
    public static void main(String[] args) {
        BiFunctionFIFilterListExamples obj = new BiFunctionFIFilterListExamples();
        List<String> list = Arrays.asList("c++", "java", "kafka", "technology");
        List<String> result = obj.filterList(list, 3, (x1, x2) -> {
            if(x1.length() > x2){
                return x1;
            }else{
                return null;
            }
        });

        List<String> result1 = obj.filterList(list, "k", (x1, x2) -> {
            if(x1.startsWith(x2)){
                return x1;
            }else{
                return null;
            }
        });

        List<Integer> listOfIntegers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> intList = obj.filterList(listOfIntegers, 2, (x1, x2) -> {
            if(x1 % x2 == 0){
                return x1;
            } else {
                return null;
            }
        });
        System.out.println(intList);
        System.out.println(result1);
    }

    public <T, U, R> List<R> filterList(List<T> list, U condition, BiFunction<T, U, R> biFunction){

        List<R> result = new ArrayList<>();
        for(T t: list){
           R r = biFunction.apply(t, condition);
           if(r != null){
               result.add(r);
           }
        }
        return result;
    }
}
