package com.sandeep.record.RecordWithAdditionalMethods;

public class Main {
    public static void main(String[] args) {
        com.sandeep.record.RecordWithAdditionalMethods.Rectangle rectangle = new com.sandeep.record.RecordWithAdditionalMethods.Rectangle(4, 5);
        System.out.println("Rectangle: " + rectangle);
        System.out.println("Length: " + rectangle.length());
        System.out.println("Width: " + rectangle.width());
        System.out.println("Area: " + rectangle.area());
    }
}
