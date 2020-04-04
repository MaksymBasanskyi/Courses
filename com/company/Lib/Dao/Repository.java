package com.company.Lib.Dao;

import com.company.Lib.Component.DataGenerator;

import java.util.ArrayList;
import java.util.List;

public class Repository<E> implements RepositoryInterface<E> {

    private DataGenerator dataGenerator;
    private Class<E> elementClass;

    public Repository(DataGenerator dataGenerator, Class<E> elementClass) {
        this.dataGenerator = dataGenerator;
        this.elementClass = elementClass;
    }

    @Override
    public E take() {
        return dataGenerator.take(elementClass);
    }

    @Override
    public List<E> takeList() {
        ArrayList<E> list = new ArrayList<>();
        for(int i=1; i<=3; i++){
            list.add(take());
        }

        return list;
    }
}
