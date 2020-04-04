package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;
import com.company.DataManagement.Component.Input;
import com.company.DataManagement.Component.Output;
import com.company.Department.Component.DepartmentTask;
import com.company.Department.Model.Employee;
import com.company.Lib.Dao.Repository;
import com.company.TenIntegers.Component.TenIntegersTask;

import java.util.Scanner;

class Dic {

    private DataManager dataManager;
    private Input input;
    private Output output;
    private DataGenerator dataGenerator;
    private TenIntegersTask tenIntegersTask;
    private DepartmentTask departmentTask;

    private DataManager getDataManager() {
        return dataManager == null ? dataManager = new DataManager(getOutput(), getInput()) : dataManager;
    }

    TenIntegersTask getTenIntegersTask() {
        return tenIntegersTask == null ? tenIntegersTask = new TenIntegersTask(
                new Repository<>(getDataGenerator(), Integer.class),
                getOutput()
        ) : tenIntegersTask;
    }

    DepartmentTask getDepartmentTask() {
        return departmentTask == null ? departmentTask = new DepartmentTask(
                new Repository<>(getDataGenerator(), Employee.class),
                new Repository<>(getDataGenerator(), Integer.class),
                getOutput()
        ) : departmentTask;
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
