package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Plant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
//@PropertySource("classpath:application.properties")
public class PlantService {
    @Value("${API_URL}")
    private String apiURL;
    @Value("${API_KEY}")
    private String key;

    public List<Plant> getPlants(String searchString){

        String url = this.apiURL + this.key + "&q=" + searchString;

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "application/json");

        HttpEntity<String> httpEntity = new HttpEntity<>("" );

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
                int id = root.path(i).path("id").asInt();
                String imageUrl = root.path(i).path("default_image").path("original_url").asText();

                Plant plant = new Plant(id, imageUrl, name);
                plantList.add(plant);
            }
        }catch (JsonProcessingException e){

        }
        return plantList;
    }

}
