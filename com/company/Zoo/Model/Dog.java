package com.company.Zoo.Model;

public class Dog implements Animal{

    @Override
    public void voice() {
        System.out.println("Bark");
    }

    @Override
    public void feed() {
        System.out.println("Dog ate bones");
    }
}
