package org.java8.example;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsExamples {
    public static void main(String[] args) {
        List<Employee> listOfEmployees = new ArrayList<>();
        Employee emp1 = new Employee(100, "Venkata", 10, LocalDate.of(2006, Month.OCTOBER, 9), 100000);
        Employee emp2 = new Employee(200, "Karthikeya", 10, LocalDate.of(2018, Month.JANUARY, 13), 50000);
        Employee emp3 = new Employee(300, "Mallik", 20, LocalDate.of(2016, Month.MARCH, 2), 350000);
        Employee emp4 = new Employee(400, "Ravi", 10, LocalDate.of(2007, Month.JUNE, 5), 200000);
        Employee emp5 = new Employee(500, "Pavan", 30, LocalDate.of(2010, Month.FEBRUARY, 6), 25000);
        Employee emp6 = new Employee(600, "Mukhesh", 10, LocalDate.of(2010, Month.AUGUST, 3), 50000);
        Employee emp7 = new Employee(700, "Rajini", 10, LocalDate.of(2016, Month.JULY, 27), 50000);
        Employee emp8 = new Employee(800, "Rajsekhar", 10, LocalDate.of(2016, Month.NOVEMBER, 25), 100000);
        Employee emp9 = new Employee(900, "Rajendra", 10, LocalDate.of(2018, Month.JUNE, 4), 130000);
        Employee emp10 = new Employee(101, "Raghavedra1234", 10, LocalDate.of(2018, Month.JANUARY, 10), 180000);
        listOfEmployees.add(emp1);
        listOfEmployees.add(emp2);
        listOfEmployees.add(emp3);
        listOfEmployees.add(emp4);
        listOfEmployees.add(emp5);
        listOfEmployees.add(emp6);
        listOfEmployees.add(emp7);
        listOfEmployees.add(emp8);
        listOfEmployees.add(emp9);
        listOfEmployees.add(emp10);
        doOperations(listOfEmployees);

    }



    public static void doOperations(List<Employee> list){

        /**
         * new CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
         *                                    (left, right) -> { left.addAll(right); return left; },
         *                                    CH_ID)
         */
        Collector collector = Collectors.toList();
        /**
         * CollectorImpl(Supplier<A> supplier,
         *                       BiConsumer<A, T> accumulator,
         *                       BinaryOperator<A> combiner,
         *                       Set<Characteristics> characteristics) {
         *             this(supplier, accumulator, combiner, castingIdentity(), characteristics);
         *         }
         */

        List<String> empNames = list.stream().map(Employee::getEmpName).collect(Collectors.toList());
        System.out.println(empNames);

        //Accumulate names into a TreeS
        TreeSet<String> treeSet = list.stream().map(Employee::getEmpName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);

        // Compute sum of salaries of employee
        DoubleSummaryStatistics total = list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        double salaries = list.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(total);
        System.out.println(salaries);

        String str = list.stream().map(e -> e.getEmpName()).collect(Collectors.joining("::", "Employee", "Company"));
        System.out.println(str);

        //Group employees by department
        Map<Integer, List<Employee>> groupByDepartmentNo = list.stream().collect(Collectors.groupingBy(Employee::getDepartmentNo));
        System.out.println("Group employees by department " + groupByDepartmentNo);

        //Group employee names by department
        Map<Integer, List<String>> group = list.stream().collect(Collectors.groupingBy(Employee::getDepartmentNo, Collectors.mapping(Employee::getEmpName, Collectors.toList())));
        System.out.println(group);

        /**
         * Basic groupingBy
         * Signature:
         *
         * public static <T, K> Collector<T, ?, Map<K, List<T>>>
         *        groupingBy(Function<? super T, ? extends K> classifier)
         * The mapper function discussed above is the classifier here. The result type of the Collector is Map<K, List<T>> as explained above.
         *
         * Using a Custom collector
         * Signature:
         * public static <T, K, A, D> Collector<T, ?, Map<K, D>>
         *        groupingBy(Function<? super T, ? extends K> classifier,
         *                   Collector<? super T, A, D> downstream)
         * This is an overloaded version of the groupingBy method. Rather than just combining the grouped items into a list, we can perform a reduction operation on the values (associated with a key) to convert it to some other value. In order to enable this, it accepts a downstream Collector.
         *
         * Custom map supplier
         * Signature:
         *
         * public static <T, K, D, A, M extends Map<K, D>>
         *        Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
         *                                     Supplier<M> mapFactory,
         *                                     Collector<? super T, A, D> downstream)
         * The API documentation makes no guarantee on the type of the resultant map. If we want to result to be a particular map type, we can pass a supplier returning a map of that type.
         */
        //Group employee names by department and employee name should be in sorting order
        Map<Integer, Set<String>> set = list.stream().collect(Collectors.groupingBy(Employee::getDepartmentNo, () -> new TreeMap<>() ,
                Collectors.mapping(Employee::getEmpName, Collectors.toSet())));
        System.out.println(set);

        // Average salary by department
        Map<Integer, Double> avgSal = list.stream().collect(Collectors.groupingBy(e -> e.getDepartmentNo(),
                                                    Collectors.averagingDouble(e -> e.getSalary())));
        System.out.println(avgSal);

        // map employee id to name by each department
        Map<Integer, Map<Integer, String>> empMap = list.stream().collect(Collectors.groupingBy(Employee::getDepartmentNo, Collectors.toMap(Employee::getEmpNo, Employee::getEmpName)));
        System.out.println(empMap);

        /**
         * Number of students from a city, grouped by department
         * For each department, show the number of students by cities belonging to that department.
         *
         * Map<String, Map<String, Long>> deptToCityCount = students.stream()
         *         .collect(Collectors.groupingBy(Student::getDepartment,
         *                 Collectors.groupingBy(student -> student.getAddress().getCity(),
         *                         Collectors.counting())));
         *
         */
        //We can achieve the same result by using Collectors.toMap (but using Collectors.counting is more precise)
        Map<Integer, Map<LocalDate, Long>> count = list.stream().collect(Collectors.groupingBy(Employee::getDepartmentNo, Collectors.toMap(Employee::getJoiningDate, employee -> 1L, Long::sum)));
        System.out.println(count);

        //Partition by departments
        Map<Boolean, List<Employee>> partition = list.stream().collect(Collectors.partitioningBy(employee -> employee.getDepartmentNo() == 10));
        System.out.println(partition);


        //Partition by departments with reduction collector
        Map<Boolean, List<String>> partition2 = list.stream().collect(
                Collectors.partitioningBy(employee -> employee.getDepartmentNo() == 10, Collectors.mapping(Employee::getEmpName, Collectors.toList())));
        System.out.println(partition2);

        // public static <T> Collector<T,?,Optional<T>> minBy(Comparator<? super T> comparator)
        //Find out minimum salary employee
        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
        Optional<Employee> minsal = list.stream().collect(Collectors.minBy(comparator));
        System.out.println(minsal.get());

        //Max sal employee
        Optional<Employee> maxSal = list.stream().collect(Collectors.maxBy(comparator));
        System.out.println(maxSal.get());

        // reducing
        Comparator<String> byLength = Comparator.comparing(String::length);
        Map<Integer, String> longestNameByDept = list.stream().collect(Collectors.groupingBy(Employee::getDepartmentNo, Collectors.reducing("",Employee::getEmpName, BinaryOperator.maxBy(byLength))));
        System.out.println(longestNameByDept);

        // reducing by min length
        Comparator<String> byLength1 = Comparator.comparing(String::length);
        Map<Integer, String> smallestNameByDept = list.stream().collect(Collectors.groupingBy(Employee::getDepartmentNo, Collectors.reducing("",Employee::getEmpName, BinaryOperator.minBy(byLength1))));
        System.out.println(smallestNameByDept);

        //public static <T,C extends Collection<T>> Collector<T,?,C> toCollection(Supplier<C> collectionFactory)
        TreeSet<String> empNamesSet = list.stream().map(Employee::getEmpName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(empNamesSet);

        list.stream().map(Employee::getEmpName).collect(Collectors.toCollection(Vector::new));

        //Group employee names by department
        Map<Integer, Map<String, List<Employee>>> group1 = list.stream().collect(Collectors.groupingBy(Employee::getDepartmentNo,
                Collectors.groupingBy(Employee::getEmpName, Collectors.toList())));
        System.out.println(group1);

        // Collectors.toMap with merge function
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(Employee::getEmpName, Employee::getDepartmentNo));
        System.out.println(map);

        // toMap() with merge function will work if user try to put same key into map.. the function returns the value object
        // Function.identity() returns same object
        list.add(new Employee(112, "Venkata", 10, LocalDate.of(2018, Month.JANUARY, 10), 180000));
        BinaryOperator<Employee> binaryOperator = (e1, e2) -> e2;
        Map<String, Employee> map1 = list.stream().collect(Collectors.toMap(Employee::getEmpName, Function.identity(), binaryOperator));
        System.out.println(map1);

        // toMap with supplier function
        Map<String, Employee> map2 = list.stream().collect(Collectors.toMap(Employee::getEmpName, Function.identity(), binaryOperator, TreeMap::new));
        System.out.println(map2);

        //reducing function
        BinaryOperator<Employee> binaryOperator1 = (e1, e2) -> {
            e1.setEmpName(e1.getEmpName().concat(e2.getEmpName()));
            return e1;
        };
        BinaryOperator<Double> binaryOperator2 = (e1, e2) -> {
            return e1.doubleValue() + e2.doubleValue();
        };

        Optional<Employee> employee = list.parallelStream().collect(Collectors.reducing(binaryOperator1));
        System.out.println(employee.get().getEmpName());

        Employee employee12 = new Employee(113, "Venkata3", 10, LocalDate.of(2018, Month.JANUARY, 10), 180000);
        Employee employee123 = list.parallelStream().collect(Collectors.reducing(employee12, binaryOperator1));
        System.out.println("employee123 :: " + employee123);

        Optional<Double> salarySum = list.parallelStream().map(employee1 -> employee1.getSalary()).collect(Collectors.reducing(binaryOperator2));
        System.out.println(salarySum.get().longValue());

        Optional<Double> finalSal =  list.parallelStream().map(employee1 -> employee1.getSalary()).reduce((a, b) -> a + b);
        System.out.println(finalSal);

        Double finalSal1 =  list.parallelStream().map(employee1 -> employee1.getSalary()).reduce(1.0, (a, b) -> a + b);
        System.out.println(finalSal1);

        Double finalSal2 =  list.parallelStream().map(employee1 -> employee1.getSalary()).reduce(0.0, Double::sum);
        System.out.println(finalSal2);


        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya","papaya");
        Map<String, Long> finalMap = new LinkedHashMap<>();
        Map<String, Long> itemsMap = items.parallelStream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(itemsMap);
        itemsMap.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed()).forEach(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);

        //If we want to sort keys
        Map<String, Long> itemsTreeMap = items.parallelStream().collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        System.out.println(itemsTreeMap);

        String val = list.parallelStream().map(e -> e.getDepartmentNo()).collect(Collectors.reducing(" ", x -> String.valueOf(x), (a, b) -> a + b));
        System.out.println(val);
    }

    public void doCollectorOperations(List<Employee> list){

       Collector<Employee, ?, Double> collector =  Collectors.summingDouble(Employee::getSalary);

       Collector<Employee, ?, Map<Integer, Double>> groupByDept = Collectors.groupingBy(Employee::getDepartmentNo, collector);

       groupByDept.supplier().get();
       //for(T d : data)
       //  groupByDept.accumulator().accept(groupByDept.supplier().get(), );
       groupByDept.combiner();
       groupByDept.finisher();
    }

}
