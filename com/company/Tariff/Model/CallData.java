package com.company.Tariff.Model;

public class CallData
{
    private String country;
    private int minutes;
    private int costPerMinute;

    public CallData(String country, int minutes, int costPerMinute)
    {
        this.country = country;
        this.minutes = minutes;
        this.costPerMinute = costPerMinute;
    }

    public int getCostPerMinute()
    {
        return costPerMinute;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public String getCountry()
    {
        return country;
    }
}
