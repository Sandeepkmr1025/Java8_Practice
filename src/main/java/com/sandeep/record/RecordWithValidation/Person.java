package com.sandeep.record.RecordWithValidation;

public record Person(int age) {
    public Person
    {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be greater than or equal to 0.");
        }
    }
}
