package com.reachUp.AStar.project.service;

import com.reachUp.AStar.project.entity.CityState;

import java.util.List;

public interface CityService {

    public List<CityState> getAllCities();
    public CityState getCitiesById(Long cityId);
    public CityState addOrUpdateCities(CityState city); //json type
    public CityState deleteCity(Long cityId) throws Exception;
}
