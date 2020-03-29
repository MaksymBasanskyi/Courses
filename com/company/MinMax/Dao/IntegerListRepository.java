package com.company.MinMax.Dao;

import com.company.DataManagement.Component.DataManager;

import java.util.ArrayList;

public class IntegerListRepository {
    private DataManager dataManager;

    public IntegerListRepository(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public ArrayList<Integer> takeList() {
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i=1; i<=3; i++){
            integers.add(dataManager.getInt());
        }

        return integers;
    }
}
