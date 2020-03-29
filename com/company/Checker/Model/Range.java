package com.company.Checker.Model;

public class Range {
    private Integer low;
    private Integer high;

    public Range(Integer low, Integer high) {
        this.low = low;
        this.high = high;
    }

    public Integer getHigh() {
        return high;
    }

    public Integer getLow() {
        return low;
    }

    public boolean contains(FloatNumber floatNumber) {
        return floatNumber.getNumber() >= low && floatNumber.getNumber() <= high;
    }
}
