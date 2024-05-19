package com.sandeep.groupingBy;

class Student {
    private String name;
    private String className;
    private String gender;
    private double score;

    Student(String name, String className, String gender, double score) {
        this.name = name;
        this.className = className;
        this.gender = gender;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getGender() {
        return gender;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " (" + score + ")";
    }
}