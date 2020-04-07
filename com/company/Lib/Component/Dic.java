package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;
import com.company.DataManagement.Component.Input;
import com.company.DataManagement.Component.Output;
import com.company.Lib.Dao.Repository;
import com.company.LoginValidation.Component.LoginValidationTask;
import com.company.Strings.Component.StringTask;
import com.company.UserName.Component.UserNameTask;

import java.util.Scanner;

class Dic {

    private DataManager dataManager;
    private Input input;
    private Output output;
    private DataGeneratorConsole dataGeneratorConsole;

    private DataManager getDataManager() {
        return dataManager == null ? dataManager = new DataManager(getOutput(), getInput()) : dataManager;
    }

    LoginValidationTask getLoginValidationTask() {
        return new LoginValidationTask(getOutput(), new Repository<>(getDataGeneratorConsole(), String.class));
    }

    UserNameTask getUserNameTask() {
        return new UserNameTask(getOutput(), new Repository<>(getDataGeneratorConsole(), String.class));
    }

    StringTask getStringTask() {
        return new StringTask(getOutput(), new Repository<>(getDataGeneratorConsole(), String.class));
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
