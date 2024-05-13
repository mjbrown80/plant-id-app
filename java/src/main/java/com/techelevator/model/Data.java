package com.techelevator.model;

import java.util.List;

public class Data {
    private List<Plant> data;
    public List<Plant> getData(){
        return data;
    }

    public void setData(List<Plant> results){
        this.data = results;
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + data +
                '}';
    }
}
