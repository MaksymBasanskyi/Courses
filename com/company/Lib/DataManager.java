package com.company.Lib;

public class DataManager
{
    private InputReaderInterface reader;
    private OutputInterface output;

    DataManager(InputReaderInterface inputReader, OutputInterface output)
    {
        this.reader = inputReader;
        this.output = output;
    }

    public String readRow()
    {
        return reader.readRow();
    }

    public void sendMessage(String message)
    {
        output.sendMessage(message);
    }

    public int takeIntValue(String message, String failMessage)
    {
        output.sendMessage(message);

        return tryTakeIntValue(failMessage);
    }

    private int tryTakeIntValue(String failMessage)
    {
        int value;
        try {
            value = Integer.parseInt(reader.readRow());
        } catch (NumberFormatException exception) {
            output.sendMessage(failMessage);
            value = tryTakeIntValue(failMessage);
        }

        return value;
    }

    public String takeNotEmptyRow(String message, String failMessage)
    {
        output.sendMessage(message);

        return tryTakeNotEmptyRow(failMessage);
    }

    private String tryTakeNotEmptyRow(String failMessage)
    {
        String row;
        row = reader.readRow();
        if (row.trim().isEmpty()) {
            output.sendMessage(failMessage);
            row = tryTakeNotEmptyRow(failMessage);
        }

        return row;
    }

    public float takeFloatValue(String message, String failMessage)
    {
        output.sendMessage(message);

        return tryTakeFloatValue(failMessage);
    }

    private float tryTakeFloatValue(String failMessage)
    {
        float value;
        try {
            value = Float.parseFloat(reader.readRow());
        } catch (NumberFormatException exception) {
            output.sendMessage(failMessage);
            value = tryTakeFloatValue(failMessage);
        }

        return value;
    }
}
