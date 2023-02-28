package com.reachUp.AStar.project.controller.endpoint;

import com.reachUp.AStar.project.entity.City;
import com.reachUp.AStar.project.service.ShortestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathFinder")
public class ShortestPathController {

    @Autowired
    private ShortestPathService shortestPathService;

    @GetMapping("/shortestpath/{startCity}/{goalCity}")
    public ResponseEntity<String> findShortestPath(
            @PathVariable("startCity") String startCityName,
            @PathVariable("goalCity") String goalCityName) {

        City startCity = new City(startCityName);
        City goalCity = new City(goalCityName);

        String shortestPath = shortestPathService.findShortestPath(startCity, goalCity);

        if (shortestPath.equals("No path found")) {
            return new ResponseEntity<>(shortestPath, HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(shortestPath, HttpStatus.OK);
        }
    }
}
