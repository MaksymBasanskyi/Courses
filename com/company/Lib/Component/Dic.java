package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;
import com.company.DataManagement.Component.Input;
import com.company.DataManagement.Component.Output;
import com.company.Garden.Component.GardenTask;
import com.company.Garden.Model.Plant;
import com.company.Lib.Dao.Repository;
import com.company.SquareCalcTask.Model.Rectangle;
import com.company.SquareCalcTask.Component.SquareCalcTask;

import java.util.Scanner;

class Dic {

    private DataManager dataManager;
    private Input input;
    private Output output;
    private DataGeneratorConsole dataGeneratorConsole;

    private DataManager getDataManager() {
        return dataManager == null ? dataManager = new DataManager(getOutput(), getInput()) : dataManager;
    }

    SquareCalcTask getSquareCalcTask() {
        return new SquareCalcTask(new Repository<>(getDataGeneratorConsole(), Rectangle.class), getOutput());
    }

    GardenTask getGardenTask() {
        return new GardenTask(new Repository<>(getDataGeneratorConsole(), Plant.class), getOutput());
    }

    private Output getOutput() {
        return output == null ? output = new Output(System.out) : output;
    }

    private Input getInput() {
        return input == null ? input = new Input(new Scanner(System.in)) : input;
    }

    private DataGeneratorConsole getDataGeneratorConsole() {
        return dataGeneratorConsole == null ? dataGeneratorConsole = new DataGeneratorConsole(getDataManager()) : dataGeneratorConsole;
    }
}
