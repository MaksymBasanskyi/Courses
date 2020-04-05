package com.company.Collections.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsTask implements TaskInterface {
    private RepositoryInterface<Integer> integerRepository;
    private OutputInterface output;

    public CollectionsTask(RepositoryInterface<Integer> integerRepository, OutputInterface output) {
        this.integerRepository = integerRepository;
        this.output = output;
    }

    @Override
    public void run() {
        List<Integer> integers = integerRepository.takeList(10);

        output.publishRow(integers.stream().map(String::valueOf).collect(Collectors.joining(",")));
        List<Integer> indicesGtFive = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > 5) {
                indicesGtFive.add(i);
            }
        }
        output.publishRow(String.format(
                "Indices greater than 5 values\n%s",
                indicesGtFive.stream().map(String::valueOf).collect(Collectors.joining(","))
        ));
        List<Integer> integerLtTwenty = integers.stream().filter(integer -> integer < 20).collect(Collectors.toList());
        output.publishRow(String.format(
                "Integers less than 5 values\n%s",
                integerLtTwenty.stream().map(String::valueOf).collect(Collectors.joining(","))
        ));
        integers.set(2, 1);
        integers.set(8, -3);
        integers.set(5, -4);
        output.publishRow(String.format(
                "new integers\n%s",
                integers.stream().map(String::valueOf).collect(Collectors.joining(","))
        ));
        integers.sort((o1, o2) -> o2 - o1);
        output.publishRow(String.format(
                "Sorted integers desc\n%s",
                integers.stream().map(String::valueOf).collect(Collectors.joining(","))
        ));
    }
}
