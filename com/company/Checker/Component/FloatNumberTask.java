package com.company.Checker.Component;

import com.company.Checker.Dao.FloatNumberRepository;
import com.company.Checker.Dao.RangeRepository;
import com.company.Checker.Model.FloatNumber;
import com.company.Checker.Model.Range;
import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;

import java.util.ArrayList;

public class FloatNumberTask implements TaskInterface {
    private FloatNumberRepository floatNumberRepository;
    private RangeRepository rangeRepository;
    private OutputInterface output;

    public FloatNumberTask(
            FloatNumberRepository floatNumberRepository,
            RangeRepository rangeRepository,
            OutputInterface output
    ) {
        this.floatNumberRepository = floatNumberRepository;
        this.rangeRepository = rangeRepository;
        this.output = output;
    }

    public void run() {
        Range range = rangeRepository.take();
        ArrayList<FloatNumber> floatNumbers = floatNumberRepository.takeList();

        boolean allInRange = true;
        for (FloatNumber floatNumber: floatNumbers) {
            boolean inRange = range.contains(floatNumber);
            allInRange &= inRange;
            output.publishRow(String.format(
                    "Number %f is %sin range [%d, %d]",
                    floatNumber.getNumber(),
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
