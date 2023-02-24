package com.reachUp.AStar.project.controller;

import com.reachUp.AStar.project.entity.CityState;
import com.reachUp.AStar.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CItyController {

    @Autowired
    private CityService cityService;

    @GetMapping("/allCities")
    public ResponseEntity<List<CityState>> getAllCities() {
        List<CityState> cities = null;
        try {
            cities = cityService.getAllCities();
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<CityState>>(cities, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CityState> getCityById(@PathVariable("id") Long cityId) {
        CityState cities = null;
        try {
            cities = cityService.getCitiesById(cityId);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<CityState> (cities, HttpStatus.OK);
    }

    @PostMapping("/addOrUpdate")
    public ResponseEntity<CityState> addOrUpdate(@RequestBody CityState city) {
        CityState cities = null;
        try {
            cities = cityService.addOrUpdateCities(city);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<CityState> (cities, HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<CityState> delete(@PathVariable("id") Long cityId) {
        CityState cities = null;
        try {
            cities = cityService.deleteCity(cityId);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<CityState> (cities, HttpStatus.OK);
    }
}
