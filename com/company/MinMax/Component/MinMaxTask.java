package com.company.MinMax.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;
import com.company.MinMax.Dao.IntegerListRepository;

import java.util.ArrayList;
import java.util.Collections;

public class MinMaxTask implements TaskInterface {
    private IntegerListRepository integerListRepository;
    private OutputInterface output;

    public MinMaxTask(IntegerListRepository integerListRepository, OutputInterface output) {
        this.integerListRepository = integerListRepository;
        this.output = output;
    }

    public void run() {
        ArrayList<Integer> integers = integerListRepository.takeList();
        int max = Collections.max(integers);
        int min = Collections.min(integers);
        output.publishRow(String.format("Max int in set: %d, min int set %d", max, min));
    }
}
