package com.company.DogShelter.Model;

import com.company.DogShelter.Model.Enum.Breed;

public class Dog {
    private String name;
    private Breed breed;
    private Integer age;

    public Dog(String name, Breed breed, Integer age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Breed getBreed() {
        return breed;
    }

    public Integer getAge() {
        return age;
    }
}
