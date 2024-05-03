package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Plant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Service
public class PlantService {
    @Value("${API_URL}")
    private String apiURL;
    @Value("${API_KEY}")
    private String key;

    public List<Plant> getPlants(String searchString){

        String url = this.apiURL + this.key + searchString;

        HttpEntity<String> httpEntity = new HttpEntity<>("");
        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode;

        List<Plant> plantList = new ArrayList<>();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(response.getBody());
        try{
            jsonNode = objectMapper.readTree((response.getBody()));
            JsonNode root = jsonNode.path("data");

            for (int i = 0; i < root.size(); i++){
                String name = root.path(i).path("common_name").asText();
                String id = root.path(i).path("id").asText();
                String imageUrl = root.path(i).path("original_url").asText();
            }
        }catch (JsonProcessingException e){

        }
        return plantList;
    }

}
