package com.company.Garden.Model;

import com.company.Garden.Model.Enum.Color;
import com.company.Garden.Model.Enum.Type;

public class Plant {
    private Color color;
    private Type type;
    private int size;

    public Plant(Color color, Type type, int size) {
        this.color = color;
        this.type = type;
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format(
                "Plant color: %s, type: %s, size: %d",
                getColor().getStringColor(),
                getType().getStringType(),
                getSize()
        );
    }
}
