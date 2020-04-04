package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;
import com.company.DataManagement.Component.Input;
import com.company.DataManagement.Component.Output;
import com.company.University.Component.UniversityTask;
import com.company.Lib.Dao.Repository;
import com.company.University.Model.Cleaner;
import com.company.University.Model.Student;
import com.company.University.Model.Teacher;
import com.company.Zoo.Component.ZooTask;
import com.company.Zoo.Model.Cat;
import com.company.Zoo.Model.Dog;

import java.util.Scanner;

class Dic {

    private DataManager dataManager;
    private Input input;
    private Output output;
    private DataGenerator dataGenerator;
    private ZooTask zooTask;
    private UniversityTask universityTask;

    ZooTask getZooTask() {
        return zooTask == null ? zooTask = new ZooTask(
                new Repository<>(getDataGenerator(), Dog.class),
                new Repository<>(getDataGenerator(), Cat.class)
        ) : zooTask;
    }

    UniversityTask getUniversityTask() {
        return universityTask == null ? universityTask = new UniversityTask(
                new Repository<>(getDataGenerator(), Student.class),
                new Repository<>(getDataGenerator(), Teacher.class),
                new Repository<>(getDataGenerator(), Cleaner.class)
        ) : universityTask;
    }

    private DataManager getDataManager() {
        return dataManager == null ? dataManager = new DataManager(getOutput(), getInput()) : dataManager;
    }

    private Output getOutput() {
        return output == null ? output = new Output(System.out) : output;
    }

    private Input getInput() {
        return input == null ? input = new Input(new Scanner(System.in)) : input;
    }

    private DataGenerator getDataGenerator() {
        return dataGenerator == null ? dataGenerator = new DataGenerator(getDataManager()) : dataGenerator;
    }
}
