package org.java8.example;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Collectors_Reducing_Example {

    public static void main(String[] args) {
        Student s1 = new Student("Shyam", 22,"A");
        Student s2 = new Student("Ram",23,"A");
        Student s3 = new Student("Mohan",22,"B");
        Student s4 = new Student(null,21,"B");
        List<Student> list = Arrays.asList(s1,s2,s3,s4);
        Comparator<Student> studentComparator = (a, b) -> a.getAge().compareTo(b.getAge()); // Comparator.comparing(Student::getAge)
        Map<String, Optional<Student>> map = list.parallelStream().collect(Collectors.groupingBy(Student::getClassName,
                Collectors.reducing((a, b) -> studentComparator.compare(a, b) >= 0 ? a : b)));// BinaryOperator.minBy(studentComparator)
        map.forEach((k, v) -> System.out.println("Class :: "+ k + " Age ::"+ ((Optional<Student>)v).get().getAge()
                + " Name :: "+ ((Optional<Student>)v).get().getName()));

    }
}
