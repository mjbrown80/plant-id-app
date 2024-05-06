package com.techelevator.services;

import com.techelevator.model.Plant;

import java.util.List;

public interface PlantAPIService {
    List<Plant> getPlantsByName(String searchString);

    List<Plant> getPlants();
}




