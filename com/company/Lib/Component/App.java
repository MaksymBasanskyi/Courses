package com.company.Lib.Component;

import com.company.Lib.Model.Enum.TaskType;

import java.io.IOException;

public class App {
    private final Dic dic = new Dic();

    public App() throws IOException {
    }

    public void run(String[] args) {
        TaskType taskType = null;
        if (args.length == 0) {
            taskType = TaskType.DEFAULT;
        } else {
            taskType = TaskType.getByCommand(args[0]);
        }
        getTask(taskType).run();
    }

    private TaskInterface getTask(TaskType taskType) {
        TaskInterface task = null;
        switch (taskType) {
            case STUDY_JAVA:
                task = dic.getStudyJavaTask();
                break;
            case THREE_THREADS:
                task = dic.getThreeThreadsTask();
                break;
            case TWO_THREADS:
                task = dic.getTwoThreadsTask();
                break;
            case DEFAULT:
                task = dic.getFileTask();
                break;
            default:
                throw new IllegalArgumentException(String.format("%s: task not found", taskType.getCommand()));
        }

        return task;
    }
}
