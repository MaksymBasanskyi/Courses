package com.company.Lib;

import java.util.Scanner;

public class InputReader implements InputReaderInterface
{
    private Scanner scanner;

    InputReader(Scanner sc)
    {
        this.scanner = sc;
    }

    public String readRow()
    {
        return scanner.nextLine();
    }

    public float readFloat() throws NumberFormatException
    {
        return Float.parseFloat(scanner.nextLine());
    }
}
