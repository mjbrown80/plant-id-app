package com.techelevator.services;

import com.techelevator.model.Plant;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class PlantService {
    @Value("${API_URL}")
    private String apiURL;
    @Value("${API_KEY}")
    private String key;

    public List<Plant> getPlants(String searchString){

        String url = this.apiURL + this.key;
    }

}
