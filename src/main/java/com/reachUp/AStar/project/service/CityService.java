package com.reachUp.AStar.project.service;

import com.reachUp.AStar.project.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CityService {

    public List<City> getAllCities();
    public City getCitiesById(Long cityId);
    public City addOrUpdateCities(City city); //json type
    public City deleteCity(Long cityId) throws Exception;
}
