package com.company.Lib;

import java.io.PrintStream;

public class Output implements OutputInterface
{
    private PrintStream printStream;

    Output(PrintStream ps)
    {
        printStream = ps;
    }


    public void sendMessage(String message)
    {
        printStream.println(message);
    }
}
