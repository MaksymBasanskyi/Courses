package com.company.FlowerBed.Component;

import com.company.Lib.DataManager;
import com.company.Lib.LogicInterface;

public class FlowerBedLogic implements LogicInterface
{
    private DataManager dataManager;

    public FlowerBedLogic(DataManager dataManager)
    {
        this.dataManager = dataManager;
    }

    public void run()
    {
        float radius = dataManager.takeFloatValue("please provide radius", "please provide valid float value");
        double perimeter = calculatePerimeter(radius);
        dataManager.sendMessage(String.format("perimeter for flower bed with radius %f is %f", radius, perimeter));
    }

    private double calculatePerimeter(float radius)
    {
        return 2 * Math.PI * radius;
    }
}
