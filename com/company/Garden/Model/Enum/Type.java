package com.company.Garden.Model.Enum;

import com.company.Garden.Exception.TypeException;

public enum Type {
    ROSE("rose"), FERN("fern");
    private String stringType;

    Type(String stringType) {
        this.stringType = stringType;
    }

    public static Type getByText(String text) throws TypeException {
        Type targetType = null;
        text = text.toLowerCase();
        for (Type type: Type.values()) {
            if (type.getStringType().equals(text)) {
                targetType = type;
            }
        }
        if (targetType == null) {
            throw new TypeException(text);
        }

        return targetType;
    }

    public String getStringType() {
        return stringType;
    }
}
