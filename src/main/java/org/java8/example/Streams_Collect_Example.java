package org.java8.example;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams_Collect_Example {

    /**
     * <R> R collect(Supplier<R> supplier,
     *               BiConsumer<R,? super T> accumulator,
     *               BiConsumer<R,R> combiner)
     * @param args
     */
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 5, 6, 8);

        Supplier<AtomicInteger> supplier = AtomicInteger::new; // AtomicInteger::new; () -> new AtomicInteger()

        BiConsumer<AtomicInteger, Integer> accumulator = (a, i) -> a.set(a.get() + i);

        BiConsumer<AtomicInteger, AtomicInteger> combiner = (a1, a2) -> a1.set(a1.get() + a2.get());

        AtomicInteger result = list.stream().collect(supplier, accumulator, combiner);

        System.out.println(result);

        List<Integer> list1 = IntStream.range(0, 99999999).boxed().collect(Collectors.toList());
        long startTime = Instant.now().toEpochMilli();
        AtomicInteger integer = list1.parallelStream().collect(sumCollector());
        long endTime = Instant.now().toEpochMilli();
        // .parallelStream() -> Time taken : 1. 289ms 2. 525ms
        // .stream() -> Time taken : 1. 855ms 2. 2418ms
        System.out.println("time taken :: " + (endTime - startTime));
        System.out.println(integer);//787459713 787459713

    }

    public static final Collector<Integer, AtomicInteger, AtomicInteger> sumCollector(){

        return new Collector<Integer, AtomicInteger, AtomicInteger>() {
            // a function that creates a new result container (mutable object) .
            // For a parallel execution, this function may be called multiple times.
            // It must return a fresh value each time.
            @Override
            public Supplier<AtomicInteger> supplier() {
                //System.out.println("supplier function called "+ Thread.currentThread().getName());
                return () -> {
                    System.out.println("supplier function called :: "+ Thread.currentThread().getName());
                    return new AtomicInteger();
                };
            }

            // a function for incorporating an additional element into a result.
            @Override
            public BiConsumer<AtomicInteger, Integer> accumulator() {
                System.out.println("accumulator function called " + Thread.currentThread().getName());
                return (a, b) -> {
                    a.set(a.get() + b);
                };
            }

            //a function for combining two values, used in parallel stream,
            // combines the results received from different threads.
            @Override
            public BinaryOperator<AtomicInteger> combiner() {
                return (a, b) -> {
                    //System.out.println("Combiner function called :: " + Thread.currentThread().getName());
                    AtomicInteger atomicInteger = new AtomicInteger();
                    atomicInteger.set(a.get() + b.get());
                    return atomicInteger;
                };
            }

            @Override
            public Function<AtomicInteger, AtomicInteger> finisher() {
                return a -> {
                    System.out.println("finisher function called " + Thread.currentThread().getName());
                    return a;
                };//Function.identity(); // a -> a;
            }

            @Override
            public Set<Characteristics> characteristics() {
                System.out.println("characteristics function called "+ Thread.currentThread().getName());
                return Collections.EMPTY_SET;
            }
        };

    }
}
