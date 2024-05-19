package com.sandeep.record.RecordsImplementingInterfaces;

public record Circle(double radius) implements Shape{
    @Override
    public void area() {
        System.out.println("Area of Circle : "+ Math.PI * radius *radius);
    }
}
