package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;
import com.company.DataManagement.Component.Input;
import com.company.DataManagement.Component.Output;
import com.company.Lib.Model.Enum.TaskType;

import java.util.Scanner;

public class Dic {

    private DataManager dataManager;
    private Input input;
    private Output output;

    private DataManager getDataManager() {
        return dataManager == null ? dataManager = new DataManager(getOutput(), getInput()) : dataManager;
    }

    private Output getOutput() {
        return output == null ? output = new Output(System.out) : output;
    }

    private Input getInput() {
        return input == null ? input = new Input(new Scanner(System.in)) : input;
    }

    public TaskInterface getTask(TaskType taskType) {
        TaskInterface task = null;
        switch (taskType) {
            case DEFAULT:
                break;
            default:
                throw new IllegalArgumentException(String.format("%s: task not found", taskType.getCommand()));
        }

        return task;
    }
}
