package com.company.Zoo.Model;

public class Cat implements Animal {

    @Override
    public void voice() {
        System.out.println("Meows");
    }

    @Override
    public void feed() {
        System.out.println("Cat ate salmon");
    }
}
