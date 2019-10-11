package com.linjc.InvokeTest.reflect.model;

public class Student extends Person {

    private String sid;
    private int grade;

    public void speak() {
        System.out.println("I am student!");
    }

    public Student() {
    }

    public Student(String sid, int grade) {
        this.sid = sid;
        this.grade = grade;
    }
}
