package com.reachUp.AStar.project.serviceImpl;

import com.reachUp.AStar.project.entity.CityState;
import com.reachUp.AStar.project.repository.CityStateRepository;
import com.reachUp.AStar.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityStateRepository cityStateRepository;
    @Override
    public List<CityState> getAllCities() {
        return (List<CityState>)cityStateRepository.findAll();
    }

    @Override
    public CityState getCitiesById(Long cityId) {
        return cityStateRepository.findById(cityId).orElse(null);
    }

    @Override
    public CityState addOrUpdateCities(CityState city) {
        return cityStateRepository.save(city);
    }

    @Override
    public CityState deleteCity(Long cityId) throws Exception {
        CityState deleteCity = null;
        try {
            deleteCity = cityStateRepository.findById(cityId).orElse(null);
            if (deleteCity == null) {
                throw new Exception("There is no city in the map");
            } else {
                cityStateRepository.deleteById(cityId);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return deleteCity;
    }
}
