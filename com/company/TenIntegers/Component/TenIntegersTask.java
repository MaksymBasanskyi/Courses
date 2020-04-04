package com.company.TenIntegers.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.Arrays;
import java.util.List;

public class TenIntegersTask implements TaskInterface {

    private RepositoryInterface<Integer> integerRepository;
    private OutputInterface output;

    public TenIntegersTask(RepositoryInterface<Integer> integerRepository, OutputInterface output) {
        this.integerRepository = integerRepository;
        this.output = output;
    }

    @Override
    public void run() {
        List<Integer> integerList = integerRepository.takeList(10);
        Integer[] integers = integerList.toArray(new Integer[0]);
        Arrays.sort(integers, (o1, o2) -> o2 - o1);
        output.publishRow(String.format("Max value in array %d", integers[0]));
        output.publishRow(String.format("Min value in array %d", integers[integers.length - 1]));
        Integer sum = Arrays.stream(integers).filter(integer -> integer > 0).mapToInt(Integer::intValue).sum();
        output.publishRow(String.format("sum of positive numbers %d", sum));
        Integer negativeElementsCount = Arrays.stream(integers)
                .filter(integer -> integer < 0)
                .toArray(Integer[]::new)
                .length;
        output.publishRow(String.format("count of negative numbers %d", negativeElementsCount));

        output.publishRow(String.format(
                "There are more %s values in array",
                negativeElementsCount > integers.length - negativeElementsCount ? "negative" : "positive"
        ));
    }
}
