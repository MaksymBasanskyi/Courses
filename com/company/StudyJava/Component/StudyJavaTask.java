package com.company.StudyJava.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;

public class StudyJavaTask implements TaskInterface {
    private OutputInterface output;

    public StudyJavaTask(OutputInterface output) {
        this.output = output;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                output.publishRow("I study Java");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            output.publishRow(e.getMessage());
        }
    }
}
