package com.company.Calculation.Model;

public class CalculationResultData
{
    private int sum;
    private int difference;
    private int product;
    private float quotient;

    public CalculationResultData(int sum, int difference, int product, float quotient)
    {
        this.sum = sum;
        this.difference = difference;
        this.product = product;
        this.quotient = quotient;
    }

    public int getSum() {
        return this.sum;
    }

    public int getDifference() {
        return this.difference;
    }

    public int getProduct() {
        return this.product;
    }

    public float getQuotient() {
        return this.quotient;
    }
}
