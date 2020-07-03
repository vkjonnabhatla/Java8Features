package org.java8.example;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EgenInterview {
    public static void main(String[] args) {
        List<Order> orderList= new ArrayList<>();
        Map<Integer, Order> map= new HashMap<>();
        Date d=new Date(System.currentTimeMillis());
        d.setMonth(3);
        Date d1=new Date(System.currentTimeMillis());
        d1.setMonth(3);
        Date d2=new Date(System.currentTimeMillis());
        d2.setMonth(3);

        List<Order> orders = Arrays.asList(new Order(1, 1, 10.5, d),
                new Order(2, 1, 20.5, d1),
                new Order(3, 2, 20.5, d2),
                new Order(4, 3, 11.5, d2),
                new Order(5, 1, 20.5, d2),
                new Order(5, 2, 80.5, d2),
                new Order(5, 3, 20.5, d2),
                new Order(5, 4, 20.5, d2)
        );

        BinaryOperator<Order> bin = (Order o1, Order o2) -> {
            o1.setAmount(o1.getAmount()+o2.getAmount());
            return o1;
        };

        orderList= orders.stream().filter(x -> x.getTimestamp().getMonth() == 3).collect(Collectors.toList());
        System.out.println(orderList);

        Map<Integer, Order> values = orderList.stream().collect(Collectors.toMap(Order::getUserId, Function.identity(), bin));
        values.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).forEach(integerOrderEntry -> {
            System.out.println(integerOrderEntry);
        });
        //values.values().stream().sorted(Comparator.comparing(Order::getAmount).reversed()).limit(5).forEachOrdered(order -> System.out.println(order));
        //System.out.println(values);
        //Comparator<Double> comparator = Comparator.comparing(Map.Entry::getValue).reversed();
        Map<Integer, Double> topPurchaseUsers = orderList.stream().collect(Collectors.groupingBy(Order::getUserId, Collectors.summingDouble(Order::getAmount)));
        //topPurchaseUsers.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).limit(3).forEachOrdered(order -> {
        //    System.out.println(order);
        //});
        //Comparator<Map.Entry> comparator =  Comparator.comparing(Map.Entry::getValue);
        topPurchaseUsers.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).forEachOrdered(order -> {
            System.out.println(order);
        });
        System.out.println(topPurchaseUsers);
        topPurchaseUsers.entrySet().stream().sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()).limit(3).forEach(order -> {
            System.out.println(order);
        });
        System.out.println(topPurchaseUsers);
        /**
         * Comparator.reverseOrder()
         * public int compare(Comparable<Object> c1, Comparable<Object> c2) {
         *             return c2.compareTo(c1);
         * }
         *
         *  Map.Entry.comparingByValue returns ->  (c1, c2) -> c1.getValue().compareTo(c2.getValue());
         *  (o1, o2) -> o2.getValue().compareTo(o1.getValue())
         *  Map.Entry.comparingByValue(Comparator.reverseOrder()) -> (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
         */

    }

    public void method(List<Order> orders){
        List<Order> orderList = orders.stream().filter(x -> x.getTimestamp().getMonth() == 3).collect(Collectors.toList());
        Map<Integer, Double> topPurchasers = orderList.stream().collect(Collectors.groupingBy(Order::getUserId, Collectors.summingDouble(Order::getAmount)));
       // topPurchasers.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue).reversed()).forEachOrdered(order -> System.out.println(order));
    }
}
