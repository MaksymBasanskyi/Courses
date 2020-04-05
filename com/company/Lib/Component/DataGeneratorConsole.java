package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;

public class DataGeneratorConsole implements DataGeneratorInterface {
    private DataManager dataManager;

    DataGeneratorConsole(DataManager dataManager) {
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
        } else {
            throw new IllegalArgumentException(String.format("%s: type not found", type.getName()));
        }

        return (T) model;
    }
}