package com.company.MinMax.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.Collections;
import java.util.List;

public class MinMaxTask implements TaskInterface {
    private RepositoryInterface<Integer> integerRepository;
    private OutputInterface output;

    public MinMaxTask(RepositoryInterface<Integer> integerRepository, OutputInterface output) {
        this.integerRepository = integerRepository;
        this.output = output;
    }

    public void run() {
        List<Integer> integers = integerRepository.takeList();
        int max = Collections.max(integers);
        int min = Collections.min(integers);
        output.publishRow(String.format("Max int in set: %d, min int set %d", max, min));
    }
}
