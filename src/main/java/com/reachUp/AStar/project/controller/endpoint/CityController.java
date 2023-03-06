package com.reachUp.AStar.project.controller.endpoint;

import com.reachUp.AStar.project.entity.City;
import com.reachUp.AStar.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping()
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = null;
        try {
            cities = cityService.getAllCities();
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long cityId) {
        City cities = null;
        try {
            cities = cityService.getCitiesById(cityId);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<City> (cities, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<City> addOrUpdate(@RequestBody @Valid City city) { //@Valid throw an exception
        City cities = null;
        try {
            cities = cityService.addOrUpdateCities(city);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<City> (cities, HttpStatus.OK);
    }
    @DeleteMapping ("/{id}")
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
