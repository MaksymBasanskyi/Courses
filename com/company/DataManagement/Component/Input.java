package com.company.DataManagement.Component;

import java.util.Scanner;

public class Input implements InputInterface {

    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getRow() {
        return scanner.nextLine();
    }
}
