package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;
import com.company.Zoo.Model.Cat;
import com.company.Zoo.Model.Dog;
import com.company.University.Model.Cleaner;
import com.company.University.Model.Student;
import com.company.University.Model.Teacher;

public class DataGenerator {
    private DataManager dataManager;

    public DataGenerator(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public <T> T take(Class<T> type) {
        Object model;

        if (type.equals(Float.class)) {
            model = dataManager.getFloat();
        } else if (type.equals(Integer.class)) {
            model = dataManager.getInt();
        } else if (type.equals(String.class)) {
            model = dataManager.getRow();
        } else if (type.equals(Dog.class)){
            model = new Dog();
        } else if (type.equals(Cat.class)){
            model = new Cat();
        } else if (type.equals(Student.class)){
            model = new Student();
        } else if (type.equals(Teacher.class)){
            model = new Teacher();
        } else if (type.equals(Cleaner.class)){
            model = new Cleaner();
        } else {
            throw new IllegalArgumentException(String.format("%s: type not found", type.getName()));
        }

        return (T) model;
    }
}