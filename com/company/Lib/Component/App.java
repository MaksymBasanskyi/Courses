package com.company.Lib.Component;

import com.company.Lib.Model.Enum.TaskType;

public class App {
    private Dic dic = new Dic();

    public void run(String[] args) {
        TaskType taskType = null;
        if (args.length == 0) {
            taskType = TaskType.DEFAULT;
        } else {
            taskType = TaskType.getByCommand(args[0]);
        }
        dic.getTask(taskType).run();
    }
}
