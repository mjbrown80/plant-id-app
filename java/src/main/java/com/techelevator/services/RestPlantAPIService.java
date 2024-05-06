package com.techelevator.services;

import com.techelevator.model.Plant;

import java.util.List;

public interface RestPlantAPIService {

    public List<Plant> getPlantsByName(String searchString);
}
