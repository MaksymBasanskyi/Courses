package com.company.Lib.Component;

import java.util.Random;

public class DataGeneratorRandom implements DataGeneratorInterface {
    private int bound;
    private boolean useNegative;

    DataGeneratorRandom(int bound, boolean useNegative) {
        this.bound = bound;
        this.useNegative = useNegative;
    }

    @Override
    public <T> T take(Class<T> type) {
        Object model;

        if (type.equals(Float.class)) {
            model = new Random().nextFloat() * bound * getSign();
        } else if (type.equals(Integer.class)) {
            model = new Random().nextInt(bound) * getSign();;
        } else {
            throw new IllegalArgumentException(String.format("%s: type not found", type.getName()));
        }

        return (T) model;
    }

    private int getSign() {
        return useNegative && new Random().nextInt(2) == 0 ? -1 : 1;
    }
}
