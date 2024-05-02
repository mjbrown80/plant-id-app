package com.techelevator.dao;

import com.techelevator.model.PlantDetail;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcPlantDao implements PlantDao{

    private JdbcTemplate template;
    public JdbcPlantDao(DataSource dataSource){
        this.template = new JdbcTemplate();
    }

    @Override
    public List<PlantDetail> getAllFavoritesByUserId(int id) {
        return null;
    }
}
