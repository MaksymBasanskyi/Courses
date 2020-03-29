package com.company.Checker.Dao;

import com.company.Checker.Model.FloatNumber;
import com.company.DataManagement.Component.DataManager;

import java.util.ArrayList;

public class FloatNumberRepository {
    private DataManager dataManager;

    public FloatNumberRepository(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public ArrayList<FloatNumber> takeList() {
        ArrayList<FloatNumber> floatNumbers = new ArrayList<>();
        for(int i=1; i<=3; i++){
            floatNumbers.add(new FloatNumber(dataManager.getFloat()));
        }
        dataManager.publishRow("Please provide float number");

        return floatNumbers;
    }
}
