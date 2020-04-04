package com.company.Zoo.Component;

import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;
import com.company.Zoo.Model.Animal;
import com.company.Zoo.Model.Cat;
import com.company.Zoo.Model.Dog;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZooTask implements TaskInterface {
    private RepositoryInterface<Dog> dogRepository;
    private RepositoryInterface<Cat> catRepository;

    public ZooTask(RepositoryInterface<Dog> dogRepository, RepositoryInterface<Cat> catRepository) {
        this.dogRepository = dogRepository;
        this.catRepository = catRepository;
    }

    @Override
    public void run() {
        List<Dog> dogs = dogRepository.takeList(getRandomInteger());
        List<Cat> cats = catRepository.takeList(getRandomInteger());
        List<Animal> animals = Stream.concat(dogs.stream(), cats.stream()).collect(Collectors.toList());
        Collections.shuffle(animals);
        animals.forEach(animal -> {animal.feed(); animal.voice();});
    }

    private Integer getRandomInteger()
    {
        return new Random().nextInt(5) + 1;
    }
}
