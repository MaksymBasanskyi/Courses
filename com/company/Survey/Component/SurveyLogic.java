package com.company.Survey.Component;

import com.company.Lib.DataManager;
import com.company.Lib.LogicInterface;

public class SurveyLogic implements LogicInterface
{
    private DataManager dataManager;

    public SurveyLogic(DataManager dataManager)
    {
        this.dataManager = dataManager;
    }

    public void run()
    {
        dataManager.sendMessage("\"How are you?\"");
        String answer = dataManager.readRow();
        dataManager.sendMessage(String.format("\"You are %s\"", answer));
    }
}
