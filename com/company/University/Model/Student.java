package com.company.University.Model;

public class Student extends Person {

    private static final String TYPE_PERSON = Student.class.getSimpleName();

    public Student() {
        System.out.println(TYPE_PERSON);
    }

    @Override
    public void print() {
        System.out.println("I'm a Student");
    }
}
