package com.company.SquareCalcTask.Exception;

public class InvalidRangeArgumentException extends Exception {
    public InvalidRangeArgumentException(String field, Number number) {
        super(String.format("Invalid range for %s, %s", field, number.toString()));
    }
}
