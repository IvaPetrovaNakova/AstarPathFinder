package com.reachUp.AStar.project.service.serviceImpl;

import com.reachUp.AStar.project.entity.City;
import com.reachUp.AStar.project.repository.CityRepository;
import com.reachUp.AStar.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> getAllCities() {
        return (List<City>)cityRepository.findAll();
    }

    @Override
    public City getCitiesById(Long cityId) {
        return cityRepository.findById(cityId).orElse(null);
    }

    @Override
    public City addOrUpdateCities(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Long cityId) throws Exception {
        try {
            City deleteCity = cityRepository.findById(cityId).orElse(null);
            if (deleteCity == null) {
                throw new Exception("There is no city in the map");
            } else {
                cityRepository.deleteById(cityId);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
