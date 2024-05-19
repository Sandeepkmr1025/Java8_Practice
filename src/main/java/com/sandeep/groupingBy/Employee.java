package com.sandeep.groupingBy;

public class Employee {
    private String name;
    private String departmentName;

    Employee(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    @Override
    public String toString() {
        return name;
    }
}

