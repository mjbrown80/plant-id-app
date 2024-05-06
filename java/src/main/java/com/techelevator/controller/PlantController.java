package com.techelevator.controller;

import com.techelevator.model.Plant;
import com.techelevator.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PlantController {

    @Autowired
    PlantService plantService;

    @RequestMapping(path="/plant", method= RequestMethod.GET)
        public List<Plant> test(@RequestParam String query){

            return plantService.getPlantsByName(query);
        }

//    @GetMapping("/plants")
//    public Plant getPlants();

}
