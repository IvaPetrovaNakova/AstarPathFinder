package com.reachUp.AStar.project.controller.endpoint;

import com.reachUp.AStar.project.entity.City;
import com.reachUp.AStar.project.exception.HttpRequestException;
import com.reachUp.AStar.project.exception.HttpResponseException;
import com.reachUp.AStar.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Each method catches specific custom exceptions
 * thrown by the CityService layer,
 * and returns an appropriate ResponseEntity
 * with an appropriate HTTP status code based
 * on the type of exception. I've also modified
 * the return type of the deleteCity method to
 * ResponseEntity<Void> to indicate that it
 * returns an empty response body.
 */

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
        try {
            List<City> cities = cityService.getAllCities();
            return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
        } catch (HttpRequestException ex) {
            return new ResponseEntity<List<City>>(HttpStatus.BAD_REQUEST);
        } catch (HttpResponseException ex) {
            return new ResponseEntity<List<City>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long cityId) {
        try {
            City city = cityService.getCitiesById(cityId);
            return new ResponseEntity<City>(city, HttpStatus.OK);
        } catch (HttpRequestException ex) {
            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
        } catch (HttpResponseException ex) {
            return new ResponseEntity<City>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<City> addOrUpdate(@RequestBody @Valid City city) { //@Valid throw an exception
        try {
            City createdCity = cityService.addOrUpdateCities(city);
            return new ResponseEntity<City>(createdCity, HttpStatus.OK);
        } catch (HttpRequestException ex) {
            return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
        } catch (HttpResponseException ex) {
            return new ResponseEntity<City>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable("id") Long cityId) {
        try {
            cityService.deleteCity(cityId);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (HttpRequestException ex) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch (HttpResponseException ex) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
