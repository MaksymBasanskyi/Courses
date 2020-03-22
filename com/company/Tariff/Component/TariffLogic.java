package com.company.Tariff.Component;

import com.company.Lib.DataManager;
import com.company.Lib.LogicInterface;
import com.company.Tariff.Model.CallData;

import java.util.HashMap;
import java.util.Map;

public class TariffLogic implements LogicInterface
{
    private DataManager dataManager;
    private String[] countries = new String[] {"GB", "US", "FR", "ES", "AU"};

    public TariffLogic(DataManager dataManager)
    {
        this.dataManager = dataManager;
    }

    public void run()
    {
        Map<String, CallData> callDataMap = new HashMap<String, CallData>();
        for (String country: countries) {
            CallData callData = buildCallData(country);
            callDataMap.put(country, callData);
        }
        int totalPrice = 0;
        int currentPrice;
        for (String country: countries) {
            CallData callData = callDataMap.get(country);
            currentPrice = callData.getMinutes() * callData.getCostPerMinute();
            totalPrice += currentPrice;
            dataManager.sendMessage(
                String.format(
                    "Country: %s, Duration: %d, Tariff: %d per minute, Price: %d",
                    country,
                    callData.getMinutes(),
                    callData.getCostPerMinute(),
                    currentPrice
                )
            );
        }
        dataManager.sendMessage(String.format("Total Price for all calls: %s", totalPrice));
    }

    private CallData buildCallData(String country)
    {
        int costPerMinute = dataManager.takeIntValue(
            String.format("How much do calls to %s cost per minute?", country),
            String.format("please provide valid price for %s", country)
        );
        int minutes = dataManager.takeIntValue(
            "How long was this call?",
             "please write in minutes"
        );

        return new CallData(country, minutes, costPerMinute);
    }
}
