package com.company.Lib.Component;

import com.company.Collections.Component.CollectionsTask;
import com.company.Collections.Component.EmployeeMapTask;
import com.company.DataManagement.Component.DataManager;
import com.company.DataManagement.Component.Input;
import com.company.DataManagement.Component.Output;
import com.company.Lib.Dao.Repository;

import java.util.Scanner;

class Dic {

    private DataManager dataManager;
    private Input input;
    private Output output;
    private DataGeneratorConsole dataGenerator;

    CollectionsTask getCollectionsTask() {
        return new CollectionsTask(new Repository<>(new DataGeneratorRandom(30 /*bounds*/, true /*useNegative*/), Integer.class), getOutput());
    }

    EmployeeMapTask getEmployeeMapTask() {
        return new EmployeeMapTask(
                new Repository<Integer>(getDataGeneratorConsole(), Integer.class),
                new Repository<String>(getDataGeneratorConsole(), String.class),
                getOutput()
        );
    }

    private DataManager getDataManager() {
        return dataManager == null ? dataManager = new DataManager(getOutput(), getInput()) : dataManager;
    }

    private Output getOutput() {
        return output == null ? output = new Output(System.out) : output;
    }

    private Input getInput() {
        return input == null ? input = new Input(new Scanner(System.in)) : input;
    }

    private DataGeneratorConsole getDataGeneratorConsole() {
        return dataGenerator == null ? dataGenerator = new DataGeneratorConsole(getDataManager()) : dataGenerator;
    }
}
