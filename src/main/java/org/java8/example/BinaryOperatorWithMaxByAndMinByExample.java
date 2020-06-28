package org.java8.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorWithMaxByAndMinByExample {

    public static void main(String[] args) {

        Developer dev1 = new Developer("jordan", BigDecimal.valueOf(9999));
        Developer dev2 = new Developer("jack", BigDecimal.valueOf(8888));
        Developer dev3 = new Developer("jaden", BigDecimal.valueOf(10000));
        Developer dev4 = new Developer("ali", BigDecimal.valueOf(2000));
        Developer dev5 = new Developer("mkyong", BigDecimal.valueOf(1));

        List<Developer> list = Arrays.asList(dev1, dev2, dev3, dev4, dev5);

        // Create a comparator
        Comparator<Developer> comparator = Comparator.comparing(Developer::getSalary);

        //BinaryOperator with custom comparator
        BinaryOperator<Developer> bo = BinaryOperator.maxBy(comparator);
        BinaryOperator<Developer> bo1 = (a, b) -> comparator.compare(a, b) >= 0 ? a : b;
        //bo is nothing but = (a, b) -> comparator.compare(a, b) >= 0 ? a : b;

        BinaryOperator<Developer> binaryOperator = BinaryOperator.minBy(comparator);

        System.out.println(find(list, bo1));


    }

    public static Developer find(List<Developer> list, BinaryOperator<Developer> binaryOperator){
        Developer result = null;
        for(Developer developer : list){
            if(result == null){
                result = developer;
            } else {
                result = binaryOperator.apply(result, developer);
            }
        }
        return result;
    }

}
