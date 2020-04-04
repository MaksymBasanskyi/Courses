package com.company.Lib.Component;

import com.company.Lib.Model.Enum.TaskType;

public class App {
    private final Dic dic = new Dic();

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
        TaskInterface task;
        switch (taskType) {
            case ZOO:
                task = dic.getZooTask();
                break;
            case DEFAULT:
                task = dic.getUniversityTask();
                break;
            default:
                throw new IllegalArgumentException(String.format("%s: task not found", taskType.getCommand()));
        }

        return task;
    }
}
