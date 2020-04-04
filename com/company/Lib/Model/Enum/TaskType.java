package com.company.Lib.Model.Enum;

public enum TaskType {
    DEFAULT("default"),
    TEN_INTEGERS_TASK("tenInt"),
    DEPARTMENT("department");
    private String command;

    TaskType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static TaskType getByCommand(String command) {
        TaskType targetTaskType = null;
        for (TaskType taskType: TaskType.values()) {
            if (taskType.getCommand().equals(command)) {
                targetTaskType = taskType;
            }
        }
        if (targetTaskType == null) {
            throw new IllegalArgumentException(String.format("No constant with command %s found", command));
        }

        return targetTaskType;
    }
}
