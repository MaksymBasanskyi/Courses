package com.company.University.Model;

public class Cleaner extends Staff {
    private static final String TYPE_PERSON = Cleaner.class.getSimpleName();

    public Cleaner() {
        System.out.println(TYPE_PERSON);
    }

    @Override
    public void salary() {
        System.out.println("My salary is 35$");
    }

    @Override
    public void print() {
        System.out.println("I'm a Cleaner");
    }
}
