package com.company.DogShelter.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.DogShelter.Model.Dog;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.*;
import java.util.stream.Collectors;

public class DogShelterTask implements TaskInterface {
    private RepositoryInterface<Dog> repository;
    private OutputInterface output;

    public DogShelterTask(RepositoryInterface<Dog> dogRepository, OutputInterface output) {
        this.repository = dogRepository;
        this.output = output;
    }

    public void run() {
        List<Dog> dogs = repository.takeList();
        ArrayList<String> duplicatedNames = getNameDuplicates(dogs);
        if (duplicatedNames.size() == 0) {
            output.publishRow("There are no duplicates by name");
        } else {
            output.publishRow(String.format("Duplicated names: %s", String.join(",", duplicatedNames)));
        }

        List<Dog> oldestDogs = getOldestDogs(dogs);
        String oldestDogsInfo = oldestDogs.stream().map(dog -> dog.getName() + " " + dog.getBreed().getText())
                .collect(Collectors.joining(",\n"));
        output.publishRow(String.format("Oldest dogs: \n%s", oldestDogsInfo));
    }

    private ArrayList<Dog> getOldestDogs(List<Dog> dogs) {
        Dog oneOfOldest = Collections.max(dogs, new Comparator<Dog>() {
            public int compare(Dog o1, Dog o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        return dogs.stream()
                .filter(dog -> dog.getAge().equals(oneOfOldest.getAge()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<String> getNameDuplicates(List<Dog> dogs) {
        ArrayList<String> duplicatedNames = new ArrayList<>();
        HashSet<String> uniques = new HashSet<>();
        for (Dog dog: dogs) {
            if (!uniques.add(dog.getName())) {
                duplicatedNames.add(dog.getName());
            }
        }

        return duplicatedNames;
    }
}
