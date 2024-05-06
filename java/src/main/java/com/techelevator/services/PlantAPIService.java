package com.techelevator.services;

import com.techelevator.model.Plant;
import com.techelevator.model.PlantDetail;

import java.util.List;

public interface PlantAPIService {
    List<Plant> getPlantsByName(String searchString);

    PlantDetail getPlantDetailById(int id);

    List<Plant> getPlants();
}




