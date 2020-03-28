package com.company.DataManagement.Component;

public class DataManager {
    private OutputInterface output;
    private InputInterface input;

    public DataManager(OutputInterface output, InputInterface input) {
        this.output = output;
        this.input = input;
    }

    public Float getFloat() {
        this.output.publishRow("please provide valid float");
        Float value;
        try {
            value = Float.parseFloat(input.getRow());
        } catch (NumberFormatException exception) {
            value = getFloat();
        }

        return value;
    }

    public String getsRow() {
        return input.getRow();
    }
}