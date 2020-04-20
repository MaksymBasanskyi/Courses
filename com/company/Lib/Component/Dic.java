package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;
import com.company.DataManagement.Component.Input;
import com.company.DataManagement.Component.Output;
import com.company.File.Component.FileTask;
import com.company.StudyJava.Component.StudyJavaTask;
import com.company.ThreeThreads.Component.ThreeThreadsTask;
import com.company.TwoThreads.Component.TwoThreadsTask;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Dic {

    private DataManager dataManager;
    private Input input;
    private Output output;
    private DataGeneratorConsole dataGeneratorConsole;
    private final String path = new File(".").getCanonicalPath();

    Dic() throws IOException {
    }


    private DataManager getDataManager() {
        return dataManager == null ? dataManager = new DataManager(getOutput(), getInput()) : dataManager;
    }

    StudyJavaTask getStudyJavaTask() {
        return new StudyJavaTask(getOutput());
    }

    TwoThreadsTask getTwoThreadsTask() {
        return new TwoThreadsTask(getOutput());
    }

    ThreeThreadsTask getThreeThreadsTask() {
        return new ThreeThreadsTask(getOutput());
    }

    FileTask getFileTask() {
        return new FileTask(getOutput(), path + "\\src\\Generated\\test.txt");
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
