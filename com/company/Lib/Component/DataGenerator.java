package com.company.Lib.Component;

import com.company.Checker.Model.Range;
import com.company.DataManagement.Component.DataManager;
import com.company.DogShelter.Model.Dog;
import com.company.DogShelter.Model.Enum.Breed;
import com.company.HttpCodes.Model.Enum.ErrorCode;

public class DataGenerator {
    private DataManager dataManager;

    public DataGenerator(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public <T> T take(Class<T> type) {
        Object model;
        if (type.equals(Dog.class)) {
            dataManager.publishRow("Dog initialization");
            dataManager.publishRow("Dog name");
            String name = dataManager.getRow();
            dataManager.publishRow("Dog breed");
            Breed breed = Breed.getByText(dataManager.getRow());
            dataManager.publishRow("Dog age");
            Integer age = dataManager.getInt();
            model = new Dog(name, breed, age);
        } else if (type.equals(Range.class)) {
            dataManager.publishRow("Range Information");
            dataManager.publishRow("please provide low border");
            int low = dataManager.getInt();
            dataManager.publishRow("please provide high border");
            int high = dataManager.getInt();
            model = new Range(low, high);
        } else if (type.equals(Float.class)) {
            model = dataManager.getFloat();
        } else if (type.equals(Integer.class)) {
            model = dataManager.getInt();
        } else if (type.equals(ErrorCode.class)) {
            model = ErrorCode.getByCode(dataManager.getInt());
        } else {
            throw new IllegalArgumentException(String.format("%s: task not found", type.getName()));
        }

        return (T) model;
    }
}
