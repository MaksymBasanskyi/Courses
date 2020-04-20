package com.company.Garden.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Garden.Model.Plant;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.List;

public class GardenTask implements TaskInterface {

    private RepositoryInterface<Plant> plantRepository;
    private OutputInterface output;

    public GardenTask(RepositoryInterface<Plant> plantRepository, OutputInterface output) {
        this.plantRepository = plantRepository;
        this.output = output;
    }

    @Override
    public void run() {
        List<Plant> plants = plantRepository.takeList(5);
        plants.forEach(p -> output.publishRow(p.toString()));
    }
}
