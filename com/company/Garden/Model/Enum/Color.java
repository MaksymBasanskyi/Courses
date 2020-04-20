package com.company.Garden.Model.Enum;

import com.company.Garden.Exception.ColorException;

public enum Color {
    GREEN("green"), YELLOW("yellow");
    private String stringColor;

    Color(String stringColor) {
        this.stringColor = stringColor;
    }

    public static Color getByText(String text) throws ColorException {
        Color targetColor = null;
        for (Color color: Color.values()) {
            if (color.getStringColor().equals(text)) {
                targetColor = color;
            }
        }
        if (targetColor == null) {
            throw new ColorException(text);
        }

        return targetColor;
    }

    public String getStringColor() {
        return stringColor;
    }
}
