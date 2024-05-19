package com.sandeep.record.NestedRecords;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(1, new Address("street1", "city1"));
        Employee employee2 = new Employee(2, new Address("street2", "city2"));
        Employee employee3 = new Employee(3, new Address("street3", "city3"));

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
        employees.forEach(System.out::println);
    }
}
