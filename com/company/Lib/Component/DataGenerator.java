package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;
import com.company.Department.Model.Employee;

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
        } else if (type.equals(Employee.class)) {
            dataManager.publishRow("Employee generation");
            dataManager.publishRow("name");
            String name = dataManager.getRow();
            dataManager.publishRow("department number");
            Integer departmentNumber = dataManager.getInt();
            dataManager.publishRow("salary");
            Integer salary = dataManager.getInt();
            model = new Employee(name, departmentNumber, salary);
        } else {
            throw new IllegalArgumentException(String.format("%s: type not found", type.getName()));
        }

        return (T) model;
    }
}