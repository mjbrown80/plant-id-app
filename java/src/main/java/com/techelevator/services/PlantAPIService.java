package com.techelevator.services;

import com.techelevator.model.Plant;
import com.techelevator.model.PlantDetail;

import java.util.List;

public interface PlantAPIService {

    PlantDetail getPlantDetailById(int id);

    List<Plant> getPlants();

    List<Plant> getPlantsByName(String searchString);
}




