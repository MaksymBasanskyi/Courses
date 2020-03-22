package com.company.Shipping.Component;

import com.company.Lib.DataManager;
import com.company.Lib.LogicInterface;

public class ShippingLogic implements LogicInterface
{
    private DataManager dataManager;

    public ShippingLogic(DataManager dataManager)
    {
        this.dataManager = dataManager;
    }

    public void run()
    {
        String name = dataManager.takeNotEmptyRow("What is your name?", "Name can not be empty");
        String address = dataManager.takeNotEmptyRow(
            String.format("Where are you live, %s?", name),
            "Please provide valid address"
        );
        dataManager.sendMessage(String.format("So %s, your address is %s", name, address));
    }
}
