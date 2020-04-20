package com.company.Garden.Exception;

public class ColorException extends Exception {
    public ColorException(String text) {
        super(String.format("Invalid color %s", text));
    }
}
