package com.company.Lib;

import com.company.Calculation.Component.CalculationLogic;
import com.company.FlowerBed.Component.FlowerBedLogic;
import com.company.Shipping.Component.ShippingLogic;
import com.company.Survey.Component.SurveyLogic;
import com.company.Tariff.Component.TariffLogic;

import java.util.Scanner;

public class App
{
    public void run(String[] args)
    {
        if (args.length == 0) {
            getOutput().sendMessage("Empty params");
        } else {
            try {
                detectLogic(args[0]).run();
            } catch (Throwable exception) {
                getOutput().sendMessage(exception.getMessage());
            }
        }
    }

    private LogicInterface detectLogic(String type)
    {
        LogicInterface logic;
        switch (type) {
            case "calculation":
                logic = buildCalculationLogic();
                break;
            case "survey":
                logic = buildSurveyLogic();
                break;
            case "flowerBed":
                logic = buildFlowerBedLogic();
                break;
            case "shipping":
                logic = buildShippingLogic();
                break;
            case "TariffLogic":
                logic = buildTariffLogic();
                break;
            default:
                throw new IllegalArgumentException(String.format("Unsupported type '%s'", type));
        }

        return logic;
    }

    private FlowerBedLogic buildFlowerBedLogic()
    {
        return new FlowerBedLogic(getDataManager());
    }

    private CalculationLogic buildCalculationLogic()
    {
        return new CalculationLogic(getDataManager());
    }

    private ShippingLogic buildShippingLogic()
    {
        return new ShippingLogic(getDataManager());
    }

    private TariffLogic buildTariffLogic()
    {
        return new TariffLogic(getDataManager());
    }

    private DataManager getDataManager()
    {
        return new DataManager(getInputReader(), getOutput());
    }

    private InputReaderInterface getInputReader()
    {
        return new InputReader(new Scanner(System.in));
    }

    private OutputInterface getOutput()
    {
        return new Output(System.out);
    }

    private SurveyLogic buildSurveyLogic()
    {
        return new SurveyLogic(getDataManager());
    }
}
