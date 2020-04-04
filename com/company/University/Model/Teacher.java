package com.company.University.Model;

public class Teacher extends Staff {
    private static final String TYPE_PERSON = Teacher.class.getSimpleName();

    public Teacher() {
        System.out.println(TYPE_PERSON);
    }

    @Override
    public void salary() {
        System.out.println("My salary is 50$");
    }

    @Override
    public void print() {
        System.out.println("I'm a Teacher");
    }
}
