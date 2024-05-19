package com.sandeep.groupingBy;

public class Employee2 {
    private String name;
    private String departmentName;
    private int age;

    public Employee2(String name, String departmentName, int age) {
        this.name = name;
        this.departmentName = departmentName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + "("+age+")";
    }
}
