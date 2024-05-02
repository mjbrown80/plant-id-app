package com.techelevator.dao;

import com.techelevator.model.PlantDetail;

import java.util.List;

public interface PlantDao {

    List<PlantDetail> getAllFavoritesByUserId(int id);
}
