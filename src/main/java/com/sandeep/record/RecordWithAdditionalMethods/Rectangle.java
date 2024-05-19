package com.sandeep.record.RecordWithAdditionalMethods;

public record Rectangle(int length, int width) {

    public int area() {
        return length * width;
    }
}
