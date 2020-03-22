package com.company.Calculation.Component;

import com.company.Calculation.Model.CalculationInputData;
import com.company.Calculation.Model.CalculationResultData;
import com.company.Lib.DataManager;
import com.company.Lib.LogicInterface;

public class CalculationLogic implements LogicInterface
{
    private DataManager dataManager;

    public CalculationLogic(DataManager dataManager)
    {
        this.dataManager = dataManager;
    }

    public void run()
    {
        CalculationInputData calculationInputData = takeInputData();
        CalculationResultData calculationResultData = calculate(calculationInputData);
        printResult(calculationResultData);
    }

    private void printResult(CalculationResultData calculationResultData)
    {
        dataManager.sendMessage("Calculation Result:");
        dataManager.sendMessage(String.format("a and b sum: %d", calculationResultData.getSum()));
        dataManager.sendMessage(String.format("difference between a and b: %d", calculationResultData.getDifference()));
        dataManager.sendMessage(String.format("a and b multiplication result: %d", calculationResultData.getProduct()));
        dataManager.sendMessage(String.format("a and b division result: %f", calculationResultData.getQuotient()));
    }

    private CalculationInputData takeInputData()
    {
        int a = takeInputNumber("a");
        int b = takeInputNumber("b");

        return new CalculationInputData(a, b);
    }

    private int takeInputNumber(String varName)
    {
        return dataManager.takeIntValue(
            String.format("Please provide number for variable %s", varName),
            String.format("please provide VALID integer for variable %s", varName)
        );
    }

    private CalculationResultData calculate(CalculationInputData calculationInputData)
    {
        int sum = calculationInputData.getA() + calculationInputData.getB();
        int difference = calculationInputData.getA() - calculationInputData.getB();
        int product = calculationInputData.getA() * calculationInputData.getB();
        float quotient = (float)calculationInputData.getA() / calculationInputData.getB();

        return new CalculationResultData(sum, difference, product, quotient);
    }
}
