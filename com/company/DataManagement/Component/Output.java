package com.company.DataManagement.Component;

import java.io.PrintStream;

public class Output implements OutputInterface {

    private PrintStream printStream;

    public Output(PrintStream ps)
    {
        printStream = ps;
    }

    @Override
    public void publishRow(String row) {
        printStream.println(row);
    }
}
