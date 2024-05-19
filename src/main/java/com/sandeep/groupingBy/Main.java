package com.sandeep.groupingBy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        // 1. Grouping a List of Strings by Their Length
        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect); // {3=[fig], 4=[date], 5=[apple, grape], 6=[banana, cherry]}
        collect.entrySet().forEach(System.out::println);
        System.out.println("******************END OF 1*********************");

        // 2. Grouping a List of Employees by Department
        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "Engineering"),
                new Employee("Charlie", "HR"),
                new Employee("David", "Engineering"),
                new Employee("Eve", "Marketing")
        );
       Map<String, List<Employee>> groupByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName));
       System.out.println(groupByDepartment); // Engineering=[Bob, David], HR=[Alice, Charlie], Marketing=[Eve]}
       groupByDepartment.entrySet().forEach(System.out::println);
        System.out.println("******************END OF 2*********************");

       // 3. Grouping a List of Numbers by Even and Odd
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, List<Integer>> groupByEvenAndOdd = integers.stream().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println(groupByEvenAndOdd); // {Even=[2, 4, 6, 8, 10], Odd=[1, 3, 5, 7, 9]}
        groupByEvenAndOdd.entrySet().forEach(System.out::println);
        System.out.println("******************END OF 3*********************");

        // 4. Grouping a List of People by Age Group
        List<Person> persons = List.of(
                new Person("Alice", 23),
                new Person("Bob", 34),
                new Person("Charlie", 17),
                new Person("David", 25),
                new Person("Eve", 45)
        );
        Map<String, List<Person>> groupByAge= persons.stream().collect(Collectors.groupingBy(person -> {
            if(person.getAge()<18)
                return "Minor";
            else if (person.getAge()>18 && person.getAge()<40) {
                return "Adult";
            }
            else
                return "Senior";
        }));
        System.out.println(groupByAge); //{Senior=[Eve(45)], Adult=[Alice(23), Bob(34), David(25)], Minor=[Charlie(17)]}
        groupByAge.entrySet().forEach(System.out::println);
        System.out.println("******************END OF 4*********************");

        // 5. Grouping a List of Transactions by Currency
        List<Transaction> transactions = List.of(
                new Transaction("USD", 1500.00),
                new Transaction("EUR", 2300.00),
                new Transaction("USD", 300.00),
                new Transaction("GBP", 4200.00),
                new Transaction("EUR", 1200.00)
        );

        Map<String, List<Transaction>> groupByCurrency = transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        System.out.println(groupByCurrency); // {EUR=[EUR:2300.0, EUR:1200.0], GBP=[GBP:4200.0], USD=[USD:1500.0, USD:300.0]}
        groupByCurrency.entrySet().forEach(System.out::println);
        System.out.println("******************END OF 5*********************\n");

        System.out.println("****************Complex groupingBy examples******************\n");

        // 1. Nested Grouping: Grouping Employees by Department and Then by Age Group
        List<Employee2> employees2 = Arrays.asList(
                new Employee2("Alice", "HR", 25),
                new Employee2("Bob", "Engineering", 34),
                new Employee2("Charlie", "HR", 28),
                new Employee2("David", "Engineering", 22),
                new Employee2("Eve", "Marketing", 45),
                new Employee2("Frank", "Marketing", 38)
        );

        Map<String, Map<String, List<Employee2>>> groupByDepartNameAndThenAgeGroup = employees2.stream().collect(Collectors.groupingBy(
                Employee2::getDepartmentName,
                Collectors.groupingBy(emp -> {
                    if (emp.getAge() < 18) {
                        return "Minor";
                    } else if (emp.getAge() > 18 && emp.getAge() < 40) {
                        return "Adult";
                    } else return "Senior";
                })));
        System.out.println(groupByDepartNameAndThenAgeGroup); // {Engineering={Adult=[Bob(34), David(22)]}, HR={Adult=[Alice(25), Charlie(28)]}, Marketing={Senior=[Eve(45)], Adult=[Frank(38)]}}
        System.out.println("******************END OF 1*********************");

        // 2. Grouping and Summarizing: Grouping Transactions by Currency and Calculating Total Amount per Currency
        List<Transaction> transactions2 = Arrays.asList(
                new Transaction("USD", 1500.00),
                new Transaction("EUR", 2300.00),
                new Transaction("USD", 300.00),
                new Transaction("GBP", 4200.00),
                new Transaction("EUR", 1200.00)
        );

        Map<String, DoubleSummaryStatistics> groupByCurrencyAndTotalAmountPerCurrency = transactions2.stream().collect(Collectors.groupingBy(
                Transaction::getCurrency,
                Collectors.summarizingDouble(Transaction::getAmount)
                ));
        groupByCurrencyAndTotalAmountPerCurrency.forEach((currency, summary) -> System.out.println(currency + ": " + summary));
//        EUR: DoubleSummaryStatistics{count=2, sum=3500.000000, min=1200.000000, average=1750.000000, max=2300.000000}
//        GBP: DoubleSummaryStatistics{count=1, sum=4200.000000, min=4200.000000, average=4200.000000, max=4200.000000}
//        USD: DoubleSummaryStatistics{count=2, sum=1800.000000, min=300.000000, average=900.000000, max=1500.000000}
        System.out.println("******************END OF 2*********************");

        // 3. Grouping and Counting: Grouping Words by Their First Letter and Counting Occurrences
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Alex", "Batista", "Cody", "Cristina");

        Map<Object, Long> groupByFirstLetter = names.stream().collect(Collectors.groupingBy(s->s.charAt(0), Collectors.counting()));
        System.out.println(groupByFirstLetter); // {A=2, B=2, C=3, D=1}
        System.out.println("******************END OF 3**********************");

        // 4. Grouping by Multiple Levels and Calculating Average: Grouping Students by Class and Then by Gender, Calculating Average Score
        List<Student> students = Arrays.asList(
                new Student("Alice", "Class A", "Female", 85.0),
                new Student("Bob", "Class A", "Male", 75.0),
                new Student("Charlie", "Class B", "Male", 95.0),
                new Student("David", "Class B", "Male", 80.0),
                new Student("Eve", "Class A", "Female", 90.0),
                new Student("Frank", "Class B", "Male", 70.0)
        );

       Map<String, Map<String,Double>> map = students.stream().collect(Collectors.groupingBy(
                Student::getClassName,
                Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getScore))
                ));
       System.out.println(map); // {Class A={Male=75.0, Female=87.5}, Class B={Male=81.66666666666667}}
       System.out.println("******************END OF 4**********************");

       // 5. Custom Grouping Logic: Grouping Products by Price Range
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.00),
                new Product("Smartphone", 800.00),
                new Product("Tablet", 600.00),
                new Product("Monitor", 300.00),
                new Product("Mouse", 50.00),
                new Product("Keyboard", 80.00)
        );

        Map<String, List<Product>> groupProductByPriceRange = products.stream().collect(Collectors.groupingBy(
                price -> {
                    if (price.getPrice() < 100) {
                        return "Cheap";
                    } else if (price.getPrice()<500) {
                        return "Affordable";
                    }
                    return "Expensive";
                }
        ));
        System.out.println(groupProductByPriceRange); // {Affordable=[Monitor ($300.0)], Expensive=[Laptop ($1200.0), Smartphone ($800.0), Tablet ($600.0)], Cheap=[Mouse ($50.0), Keyboard ($80.0)]}
        System.out.println("******************END OF 5**********************");
    }
}
