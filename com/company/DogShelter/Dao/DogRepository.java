package com.company.DogShelter.Dao;

import com.company.DataManagement.Component.DataManager;
import com.company.DogShelter.Model.Dog;
import com.company.DogShelter.Model.Enum.Breed;

import java.util.ArrayList;

public class DogRepository {
    private DataManager dataManager;

    public DogRepository(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public ArrayList<Dog> takeList() {
        ArrayList<Dog> dogs = new ArrayList<>();
        for(int i=1; i<=3; i++){
            dogs.add(take());
        }

        return dogs;
    }

    public Dog take() {
        dataManager.publishRow("Dog initialization");
        dataManager.publishRow("Dog name");
        String name = dataManager.getRow();
        dataManager.publishRow("Dog breed");
        Breed breed = Breed.getByText(dataManager.getRow());
        dataManager.publishRow("Dog age");
        Integer age = dataManager.getInt();

        return new Dog(name, breed, age);
    }
}
