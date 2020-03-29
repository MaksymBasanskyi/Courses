package com.company.Lib.Component;

import com.company.Checker.Component.FloatNumberTask;
import com.company.Checker.Dao.FloatNumberRepository;
import com.company.Checker.Dao.RangeRepository;
import com.company.DataManagement.Component.DataManager;
import com.company.DataManagement.Component.Input;
import com.company.DataManagement.Component.Output;
import com.company.DogShelter.Component.DogShelterTask;
import com.company.DogShelter.Dao.DogRepository;
import com.company.HttpCodes.Component.ErrorCodeTask;
import com.company.HttpCodes.Dao.ErrorCodeRepository;
import com.company.MinMax.Component.MinMaxTask;
import com.company.MinMax.Dao.IntegerListRepository;

import java.util.Scanner;

class Dic {

    private DataManager dataManager;
    private Input input;
    private Output output;
    private FloatNumberTask floatNumberTask;
    private MinMaxTask minMaxTask;
    private ErrorCodeTask errorCodeTask;
    private DogShelterTask dogShelterTask;

    FloatNumberTask getFloatNumberTask() {
        return floatNumberTask == null ? floatNumberTask = new FloatNumberTask(
                new FloatNumberRepository(getDataManager()),
                new RangeRepository(getDataManager()),
                getOutput()
        ) : floatNumberTask;
    }

    MinMaxTask getMinMaxTask() {
        return minMaxTask == null ? minMaxTask = new MinMaxTask(
                new IntegerListRepository(getDataManager()),
                getOutput()
        ) : minMaxTask;
    }

    ErrorCodeTask getErrorCodeTask() {
        return errorCodeTask == null ? errorCodeTask = new ErrorCodeTask(
                new ErrorCodeRepository(getDataManager()),
                getOutput()
        ) : errorCodeTask;
    }

    DogShelterTask getDogShelterTask() {
        return dogShelterTask == null ? dogShelterTask = new DogShelterTask(
                new DogRepository(getDataManager()),
                getOutput()
        ) : dogShelterTask;
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
}
