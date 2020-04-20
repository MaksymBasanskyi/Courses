package com.company.Garden.Exception;

public class TypeException extends Exception {
    public TypeException(String text) {
        super(String.format("Invalid type %s", text));
    }
}