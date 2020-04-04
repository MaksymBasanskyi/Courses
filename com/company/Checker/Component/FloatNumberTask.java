package com.company.Checker.Component;

import com.company.Checker.Model.Range;
import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.List;

public class FloatNumberTask implements TaskInterface {
    private RepositoryInterface<Float> floatRepository;
    private RepositoryInterface<Range> rangeRepository;
    private OutputInterface output;

    public FloatNumberTask(RepositoryInterface<Float> floatRepository, RepositoryInterface<Range> rangeRepository, OutputInterface output) {
        this.floatRepository = floatRepository;
        this.rangeRepository = rangeRepository;
        this.output = output;
    }

    public void run() {
        Range range = rangeRepository.take();
        List<Float> floatNumbers = floatRepository.takeList();

        boolean allInRange = true;
        for (Float aFloat: floatNumbers) {
            boolean inRange = range.contains(aFloat);
            allInRange &= inRange;
            output.publishRow(String.format(
                    "Number %f is %sin range [%d, %d]",
                    aFloat,
                    inRange ? "" : "not ",
                    range.getLow(),
                    range.getHigh()
            ));
        }

        output.publishRow(String.format(
                "All numbers are %sin range [%d, %d]",
                allInRange ? "" : "not ",
                range.getLow(),
                range.getHigh()
        ));
    }
}
