package com.company.Lib.Component;

import com.company.Checker.Component.FloatNumberTask;
import com.company.Checker.Model.Range;
import com.company.DataManagement.Component.DataManager;
import com.company.DataManagement.Component.Input;
import com.company.DataManagement.Component.Output;
import com.company.DogShelter.Component.DogShelterTask;
import com.company.DogShelter.Model.Dog;
import com.company.HttpCodes.Component.ErrorCodeTask;
import com.company.HttpCodes.Model.Enum.ErrorCode;
import com.company.Lib.Dao.Repository;
import com.company.MinMax.Component.MinMaxTask;

import java.util.Scanner;

class Dic {

    private DataManager dataManager;
    private Input input;
    private Output output;
    private DataGenerator dataGenerator;
    private FloatNumberTask floatNumberTask;
    private MinMaxTask minMaxTask;
    private ErrorCodeTask errorCodeTask;
    private DogShelterTask dogShelterTask;

    FloatNumberTask getFloatNumberTask() {
        return floatNumberTask == null ? floatNumberTask = new FloatNumberTask(
                new Repository<>(getDataGenerator(), Float.class),
                new Repository<>(getDataGenerator(), Range.class),
                getOutput()
        ) : floatNumberTask;
    }

    MinMaxTask getMinMaxTask() {
        return minMaxTask == null ? minMaxTask = new MinMaxTask(
                new Repository<>(getDataGenerator(), Integer.class),
                getOutput()
        ) : minMaxTask;
    }

    ErrorCodeTask getErrorCodeTask() {
        return errorCodeTask == null ? errorCodeTask = new ErrorCodeTask(
                new Repository<>(getDataGenerator(), ErrorCode.class),
                getOutput()
        ) : errorCodeTask;
    }

    DogShelterTask getDogShelterTask() {
        return dogShelterTask == null ? dogShelterTask = new DogShelterTask(
                new Repository<>(getDataGenerator(), Dog.class),
                getOutput()
        ) : dogShelterTask;
    }

    private DataManager getDataManager() {
        return dataManager == null ? dataManager = new DataManager(getOutput(), getInput()) : dataManager;
    }

    private DataGenerator getDataGenerator() {
        return dataGenerator == null ? dataGenerator = new DataGenerator(getDataManager()) : dataGenerator;
    }

    private Output getOutput() {
        return output == null ? output = new Output(System.out) : output;
    }

    private Input getInput() {
        return input == null ? input = new Input(new Scanner(System.in)) : input;
    }
}
