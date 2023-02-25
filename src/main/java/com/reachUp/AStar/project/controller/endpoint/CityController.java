package com.reachUp.AStar.project.controller.endpoint;

import com.reachUp.AStar.project.entity.City;
import com.reachUp.AStar.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/allCities")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = null;
        try {
            cities = cityService.getAllCities();
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long cityId) {
        City cities = null;
        try {
            cities = cityService.getCitiesById(cityId);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<City> (cities, HttpStatus.OK);
    }

    @PostMapping("/addOrUpdate")
    public ResponseEntity<City> addOrUpdate(@RequestBody City city) {
        City cities = null;
        try {
            cities = cityService.addOrUpdateCities(city);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<City> (cities, HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<City> delete(@PathVariable("id") Long cityId) {
        City cities = null;
        try {
            cities = cityService.deleteCity(cityId);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<City> (cities, HttpStatus.OK);
    }
}
