package com.company.SquareCalcTask.Model;

import com.company.SquareCalcTask.Exception.InvalidRangeArgumentException;

public class Rectangle implements FigureInterface {
    private int a;
    private int b;

    public Rectangle(int a, int b) throws InvalidRangeArgumentException {
        if (a <= 0) {
            throw new InvalidRangeArgumentException("a", a);
        }
        if (b <= 0) {
            throw new InvalidRangeArgumentException("b", b);
        }
        this.a = a;
        this.b = b;
    }

    public int square()
    {
        return a * b;
    }
}
