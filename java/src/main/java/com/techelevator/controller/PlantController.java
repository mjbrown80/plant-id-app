package com.techelevator.controller;

import com.techelevator.model.Plant;
import com.techelevator.model.PlantDetail;
import com.techelevator.services.RestPlantAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class PlantController {

    @Autowired
    RestPlantAPIService plantService;

    @GetMapping("/plantlist")
    public List<Plant> getPlants(){
        return plantService.getPlants();
    }

    @GetMapping("/plants/{id}")
    public PlantDetail getPlantDetailById(@PathVariable int id){
        return plantService.getPlantDetailById(id);
    }
    @RequestMapping(path="/plant", method= RequestMethod.GET)
        public List<Plant> plantSearch(@RequestParam String query){

            return plantService.getPlantsByName(query);
        }



}
