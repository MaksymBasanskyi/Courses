package com.company.DogShelter.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.DogShelter.Dao.DogRepository;
import com.company.DogShelter.Model.Dog;
import com.company.Lib.Component.TaskInterface;

import java.util.*;
import java.util.stream.Collectors;

public class DogShelterTask implements TaskInterface {
    private DogRepository dogRepository;
    private OutputInterface output;

    public DogShelterTask(DogRepository dogRepository, OutputInterface output) {
        this.dogRepository = dogRepository;
        this.output = output;
    }

    public void run() {
        ArrayList<Dog> dogs = dogRepository.takeList();
        ArrayList<String> duplicatedNames = getNameDuplicates(dogs);
        if (duplicatedNames.size() == 0) {
            output.publishRow("There are no duplicates by name");
        } else {
            output.publishRow(String.format("Duplicated names: %s", String.join(",", duplicatedNames)));
        }

        ArrayList<Dog> oldestDogs = getOldestDogs(dogs);
        String oldestDogsInfo = oldestDogs.stream().map(dog -> dog.getName() + " " + dog.getBreed().getText())
                .collect(Collectors.joining(",\n"));
        output.publishRow(String.format("Oldest dogs: \n%s", oldestDogsInfo));
    }

    private ArrayList<Dog> getOldestDogs(ArrayList<Dog> dogs) {
        Dog oneOfOldest = Collections.max(dogs, new Comparator<Dog>() {
            public int compare(Dog o1, Dog o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        return dogs.stream()
                .filter(dog -> dog.getAge().equals(oneOfOldest.getAge()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<String> getNameDuplicates(ArrayList<Dog> dogs) {
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
