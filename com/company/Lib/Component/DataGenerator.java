package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;

public class DataGenerator {
    private DataManager dataManager;

    public DataGenerator(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public <T> T take(Class<T> type) {
        Object model = null;

        return (T) model;
    }
}