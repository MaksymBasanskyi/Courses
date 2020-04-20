package com.company.Lib.Component;

import com.company.DataManagement.Component.DataManager;
import com.company.Garden.Exception.ColorException;
import com.company.Garden.Exception.TypeException;
import com.company.Garden.Model.Enum.Color;
import com.company.Garden.Model.Enum.Type;
import com.company.Garden.Model.Plant;
import com.company.SquareCalcTask.Exception.InvalidRangeArgumentException;
import com.company.SquareCalcTask.Model.Rectangle;

public class DataGeneratorConsole implements DataGeneratorInterface {
    private DataManager dataManager;

    DataGeneratorConsole(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public <T> T take(Class<T> type) {
        Object model;

        if (type.equals(Float.class)) {
            model = dataManager.getFloat();
        } else if (type.equals(Integer.class)) {
            model = dataManager.getInt();
        } else if (type.equals(String.class)) {
            model = dataManager.getRow();
        } else if (type.equals(Plant.class)) {
            try {
                dataManager.publishRow("Color");
                Color color = Color.getByText(dataManager.getRow());
                dataManager.publishRow("Type");
                Type plantType = Type.getByText(dataManager.getRow());
                dataManager.publishRow("size");
                int size = dataManager.getInt();
                model = new Plant(color, plantType, size);
            } catch (ColorException | TypeException e) {
                dataManager.publishRow(e.getMessage());
                model = take(type);
            }
        } else if (type.equals(Rectangle.class)) {
            try {
                model = new Rectangle(dataManager.getInt(), dataManager.getInt());
            } catch (InvalidRangeArgumentException e) {
                dataManager.publishRow(e.getMessage());
                model = take(type);
            }
        } else {
            throw new IllegalArgumentException(String.format("%s: type not found", type.getName()));
        }

        return (T) model;
    }
}