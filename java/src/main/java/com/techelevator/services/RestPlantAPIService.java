package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Plant;
import com.techelevator.model.PlantDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestPlantAPIService implements PlantAPIService {
    @Value("${API_URL}")
    private String apiURL;
    @Value("${API_KEY}")
    private String key;

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode;

    @Override
    public List<Plant> getPlants() {
        String url = this.apiURL + this.key;
        String response = restTemplate.getForObject(url, String.class);

        List<Plant> plants = new ArrayList<>();

        try {
            jsonNode = objectMapper.readTree(response);
            JsonNode root = jsonNode.path("data");
            plants = mapForNodes(root);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return plants;
    }

    @Override
    public PlantDetail getPlantDetailById(int id) {

        PlantDetail plantDetail = restTemplate.getForObject(apiURL + key + id, PlantDetail.class);
        return plantDetail;
    }

    @Override
    public List<Plant> getPlantsByName(String searchString) {

        String url = this.apiURL + this.key + "&q=" + searchString;

        HttpEntity<String> httpEntity = new HttpEntity<>("");

        List<Plant> plantList = new ArrayList<>();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(response.getBody());
        try {
            jsonNode = objectMapper.readTree((response.getBody()));
            JsonNode root = jsonNode.path("data");

            for (int i = 0; i < root.size(); i++) {
                String name = root.path(i).path("common_name").asText();
                int id = root.path(i).path("id").asInt();
                String imageUrl = root.path(i).path("default_image").path("original_url").asText();

                Plant plant = new Plant(id, imageUrl, name);
                plantList.add(plant);
            }
        } catch (JsonProcessingException e) {

        }
        return plantList;
    }



    private List<Plant> mapForNodes(JsonNode root) {
        List<Plant> plantList = new ArrayList<>();
        for (int i = 0; i < root.size(); i++) {
            String name = root.path(i).path("common_name").asText();
            int id = root.path(i).path("id").asInt();
            String imageUrl = root.path(i).path("default_image").path("original_url").asText();

            Plant plant = new Plant(id, imageUrl, name);
            plantList.add(plant);
        }
        return plantList;
    }
}
