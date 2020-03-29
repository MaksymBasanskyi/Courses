package com.company.Checker.Dao;

import com.company.Checker.Model.Range;
import com.company.DataManagement.Component.DataManager;

public class RangeRepository {
    private DataManager dataManager;

    public RangeRepository(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public Range take() {
        dataManager.publishRow("Range Information");
        dataManager.publishRow("please provide low border");
        int low = dataManager.getInt();
        dataManager.publishRow("please provide high border");
        int high = dataManager.getInt();

        return new Range(low, high);
    }
}
