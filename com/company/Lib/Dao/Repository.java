package com.company.Lib.Dao;

import com.company.Lib.Component.DataGeneratorInterface;

import java.util.ArrayList;
import java.util.List;

public class Repository<E> implements RepositoryInterface<E> {

    private DataGeneratorInterface dataGenerator;
    private Class<E> elementClass;

    public Repository(DataGeneratorInterface dataGenerator, Class<E> elementClass) {
        this.dataGenerator = dataGenerator;
        this.elementClass = elementClass;
    }

    @Override
    public E take() {
        return dataGenerator.take(elementClass);
    }

    @Override
    public List<E> takeList(int limit) {
        ArrayList<E> list = new ArrayList<>();
        for(int i=1; i<=limit; i++){
            list.add(take());
        }

        return list;
    }
}