package com.sandeep.record.RecordWithValidation;

public class Main {
    public static void main(String[] args) {
        try{
            Person person = new Person(-5);
            System.out.println(person);
        }
        catch(Exception e){
            System.out.println(e);
        }


        Person person2 = new Person(5);
        System.out.println(person2);
    }
}
