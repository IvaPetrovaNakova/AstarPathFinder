package com.reachUp.AStar.project.service;

import com.reachUp.AStar.project.entity.City;

public interface ShortestPathService {
    public String findShortestPath(City startCity, City goalCity);
}
