package com.sandeep;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        // 1. Write a Java program to implement a lambda expression to find the sum of two integers.

        BiFunction<Integer, Integer, Integer> function = Integer::sum;
        System.out.println(function.apply(1, 2));
        System.out.println("**********************END OF 1******************");

        //2. Write a Java program to implement a lambda expression to check if a given string is empty.

        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));
        //System.out.println(predicate.test(null));
        System.out.println(predicate.test("abc"));
        System.out.println("**********************END OF 2******************");

        // 3. Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.

        List<String> list = Arrays.asList("a", "b", "c");
        Function<String, String> function1 = String::toUpperCase;
        Function<String, String> function2 = String::toLowerCase;

        //List<String> collect1 = list.stream().map(function1::apply).collect(Collectors.toList());
        List<String> collect1 = list.stream().map(function1).collect(toList());

        //List<String> collect2 = list.stream().map(s -> function2.apply(s)).collect(Collectors.toList());
        List<String> collect2 = list.stream().map(function2).collect(toList());
        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println("**********************END OF 3******************");

        // 4. Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> evenList = integerList.stream().filter(n -> n % 2 == 0).toList();
        List<Integer> oddList = integerList.stream().filter(n -> n % 2 != 0).toList();
        System.out.println(evenList);
        System.out.println(oddList);
        System.out.println("**********************END OF 4******************");

        // 5. Write a Java program to implement a lambda expression to sort a list of strings in alphabetical order.

        List<String> stringList = Arrays.asList("a", "z", "c", "b", "d", "y", "f");

        // Solution for alphabetical order
        // Solution 1
//        Stream<String> sorted1 = stringList.stream().distinct().sorted(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        // Solution 2
        //Stream<String> sorted1 = stringList.stream().distinct().sorted(Comparator.naturalOrder());
        //System.out.println("alphabetical sorted order : "+sorted1.toList());

        // Solution 3
        stringList.sort(String::compareToIgnoreCase);
        System.out.println("alphabetical sorted order : "+stringList);

        // Solution for reverse alphabetical order
        // Solution 1
//        Stream<String> sorted2 = stringList.stream().distinct().sorted(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });

        // Solution 2
        List<String> list1 = stringList.stream().distinct().sorted(Comparator.reverseOrder()).toList();

        // Third element
        String ele = stringList.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElseThrow(RuntimeException::new);

        //stringList.sort(Comparator.reverseOrder());
        System.out.println("reverse alphabetical sorted order : "+list1);
        System.out.println(ele);
        System.out.println("**********************END OF 5******************");

        // 6. Write a Java program to implement a lambda expression to find the average of a list of doubles.

        List<Double> doubleList = Arrays.asList(1.0, 5.0, 3.0, 4.0, 2.0, 6.0, 7.0, 8.0);
        // Solution 1
        //Double avgValue = doubleList.stream().collect(Collectors.averagingDouble(Double::doubleValue));
        // Solution 2
        //double avgValue = doubleList.stream().reduce(0.0, Double::sum)/doubleList.size();
        double avgValue = doubleList.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        System.out.println("average value : "+avgValue);
        System.out.println("**********************END OF 6******************");

        // 7. Write a Java program to implement a lambda expression to remove duplicates from a list of integers.

        List<Integer> integerList2 = Arrays.asList(1, 7, 3, 4, 5, 6, 7, 5, 9);
        List<Integer> distinctList = integerList2.stream().distinct().toList();
        System.out.println("distinct list : "+distinctList);
        System.out.println("**********************END OF 7******************");

        // 8. Write a lambda expression to implement a lambda expression to calculate the factorial of a given number.
        // Solution 1
        Function<Long, Long> function3 = (num) -> {
            int result = 1;
            for (int i = 1; i<=num; i++) {
                result *= i;
            }
            return (long) result;
        };

        System.out.println("factorial_result1 :: "+function3.apply(9L));

        // Solution 2
        LongUnaryOperator factorial = n -> {
            long result = 1;
            for (long i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        // Calculate the factorial of a number using the lambda expression
        System.out.println("factorial_result2 : "+factorial.applyAsLong(5));
        System.out.println("**********************END OF 8******************");

        // 9. Write a Java program to implement a lambda expression to create a lambda expression to check if a number is prime.

        Predicate<Integer> predicate2 = num -> {
            if (num<=1) {
                return false;
            }

            for (int i=2; i<=Math.sqrt(num); i++ )
            {
                if(num%i==0)
                {
                    return false;
                }
            }
            return true;
        };

        System.out.println(predicate2.test(1));
        System.out.println(predicate2.test(2));
        System.out.println(predicate2.test(3));
        System.out.println(predicate2.test(4));
        System.out.println(predicate2.test(5));
        System.out.println("**********************END OF 9******************");

        // 10. Write a Java program to implement a lambda expression to concatenate two strings.
        // Solution 1
        BiFunction<String, String, String> function4 = (s1, s2) -> s1 + s2;
        System.out.println("Concatenate two strings : "+function4.apply("ABC", "DEF"));

        // Solution 2
        // Concatenate the strings using StringJoiner and Java 8 stream
        StringJoiner joiner = new StringJoiner("");
        joiner.add("str1").add("str2");
        System.out.println(joiner);
        System.out.println("**********************END OF 10******************");

        // 11. Write a Java program to implement a lambda expression to find the maximum and minimum values in a list of integers.

        List<Integer> integers = Arrays.asList(8, 2, 3, 4, 7, 6, 5, 1, 9);
        // Solution 1
        int max1 = integers.stream().mapToInt(Integer::intValue).max().orElse(0);
        int min1 = integers.stream().mapToInt(Integer::intValue).min().orElse(0);

        // Solution 2
        Integer max2 = integers.stream().max(Integer::compareTo).orElse(0);
        Integer min2 = integers.stream().min(Integer::compareTo).orElse(0);

        System.out.println("max1 : "+max1);
        System.out.println("min1 : "+min1);

        System.out.println("max2 : "+max2);
        System.out.println("min2 : "+min2);
        System.out.println("**********************END OF 11******************");

        // 12. Write a Java program to create a lambda expression to multiply and sum all elements in a list of integers.

        List<Integer> integers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int multi = integers1.stream().reduce(1, (n1, n2) -> n1 * n2);
        int sum = integers1.stream().reduce(0, Integer::sum);
        System.out.println("multi : "+multi);
        System.out.println("sum : "+sum);
        System.out.println("**********************END OF 12******************");

        // 13. Write a Java program to implement a lambda expression to count words in a sentence.

        String sentence = "Java ia very good programming language";
        // Solution 1
        String[] words = sentence.split(" ");
        System.out.println("Words count1 : "+ Arrays.stream(words).count());

        // Solution 2
        Function<String, Integer> function5 = str -> str.split(" ").length;
        System.out.println("Words count2 : "+ function5.apply(sentence));
        System.out.println("**********************END OF 13******************");

        // 14. Write a Java program to implement a lambda expression to check if a given string is a palindrome.

        Predicate<String> predicate1 = str -> new StringBuilder(str).reverse().toString().equals(str);
        System.out.println("Is abc palindrome : "+predicate1.test("abc"));
        System.out.println("Is abc palindrome : "+predicate1.test("aba"));
        System.out.println("Is abc palindrome : "+predicate1.test("A"));
        System.out.println("Is abc palindrome : "+predicate1.test("AB"));
        System.out.println("**********************END OF 14******************");

        // 15. Write a Java program to implement a lambda expression to calculate the sum of squares of all odd and even numbers in a list.
        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 7, 9, 8, 4, 6, 5);
        // Solution 1
        Integer evenSquaredSum = integerList1.stream().filter(n -> n % 2 == 0).map(n -> n * n).reduce(0, Integer::sum);
        Integer oddSquaredSum = integerList1.stream().filter(n -> n % 2 != 0).map(n -> n * n).reduce(0, Integer::sum);
        System.out.println("evenSquaredSum : "+ evenSquaredSum);
        System.out.println("oddSquaredSum : "+ oddSquaredSum);

        // Solution 2
        int evenSquaredSum2 = integerList1.stream().filter(n -> n % 2 == 0).mapToInt(n -> n * n).sum();
        int oddSquaredSum2 = integerList1.stream().filter(n -> n % 2 != 0).mapToInt(n -> n * n).sum();
        System.out.println("evenSquaredSum2 : "+ evenSquaredSum2);
        System.out.println("oddSquaredSum2 : "+ oddSquaredSum2);
        System.out.println("**********************END OF 15******************");

        // 16. Write a Java program to implement a lambda expression to check if a list of strings contains a specific word.

        List<String> words16 = Arrays.asList("Red", "Green", "Blue", "Orange", "Black");
        String searchWord = "red";
        boolean matchedWord = words16.stream().anyMatch(w -> w.equals(searchWord));
        System.out.println(matchedWord);
        System.out.println("**********************END OF 16******************");

        // 17. Write a Java program to implement a lambda expression to find the length of the longest and smallest string in a list.

        List<String> list17 = Arrays.asList("Red", "Green", "Blue", "Orange", "Black");
        int minLength = list17.stream().mapToInt(String::length).min().orElse(0);
        System.out.println("minLength : "+minLength);
        int maxLength = list17.stream().mapToInt(String::length).max().orElse(0);
        System.out.println("maxLength : "+maxLength);
        System.out.println("**********************END OF 17******************");

        // 18. Write a Java program to implement a lambda expression to check if a given number is a perfect square.

        Predicate<Integer> isSquare = n ->
        {
            int sqrt = (int) Math.sqrt(n);
            return sqrt * sqrt == n;
        };
        System.out.println("Is number a perfect square : "+isSquare.test(4));
        System.out.println("Is number a perfect square : "+isSquare.test(3));
        System.out.println("Is number a perfect square : "+isSquare.test(0));
        System.out.println("Is number a perfect square : "+isSquare.test(1));
        System.out.println("**********************END OF 18******************");

        // 19. Write a Java program to implement a lambda expression to find the second largest and smallest element in an array.

        List<String> list19 = Arrays.asList("Red", "Green", "Blue", "Orange", "Black");
        // Solution 1
        String min19 = list19.stream().sorted(Comparator.comparingInt(String::length)).skip(1).findFirst().orElse(null);
        System.out.println("min19 : "+min19);
        String max19 = list19.stream().sorted((s1, s2) -> s2.length() - s1.length()).skip(1).findFirst().orElse(null);
        System.out.println("max19 : "+max19);
        // Solution 2
        String max = list19.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length())
                    return 1;
                else if (o1.length() > o2.length())
                    return -1;
                return 0;
            }
        }).skip(1).findFirst().orElse(null);
        System.out.println("max : "+max);
        System.out.println("**********************END OF 19******************");

        // 20. Write a Java program to implement a lambda expression to sort a list of objects based on a specific attribute.

        List<Employee> employees = Arrays.asList(
                new Employee("A", 22, 1000),
                new Employee("B", 28, 3000),
                new Employee("C", 25, 2000),
                new Employee("C", 25, 7000),
                new Employee("C", 25, 6000)
        );

        // Sorting based on employee's salary.
        employees.sort(Comparator.comparing(Employee::getSalary));
        System.out.println(employees);

        // Find out second-highest salary.
        double salary1 = Objects.requireNonNull(employees.stream().distinct().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null)).getSalary();
        double salary2 = employees.stream().mapToDouble(Employee::getSalary).distinct().sorted().skip(1).findFirst().orElse(0);
        double salary3 = employees.stream().mapToDouble(Employee::getSalary).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0.0);
        System.out.println("second highest salary1 : "+salary1);
        System.out.println("second highest salary2 : "+salary2);
        System.out.println("second highest salary3 : "+salary3);
        System.out.println("**********************END OF 20******************");




    }




}