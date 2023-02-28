package com.reachUp.AStar.project.service.serviceImpl;

import com.reachUp.AStar.project.SearchProblem;
import com.reachUp.AStar.project.entity.City;
import com.reachUp.AStar.project.entity.Node;
import com.reachUp.AStar.project.service.PathFinder;
import com.reachUp.AStar.project.service.ShortestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortestPathServiceImpl implements ShortestPathService {

    @Override
    public String findShortestPath(City startCity, City goalCity) {

                SearchProblem problem = new SearchProblem(startCity, goalCity);

                PathFinder pathFinder = new PathFinder();
                Node shortestPath = pathFinder.solve(problem);

                if (shortestPath.state.equals(goalCity)) {
                    StringBuilder sb = new StringBuilder();
                    while (shortestPath.parent != null) {
                        sb.insert(0, shortestPath.state.getCity() + " -> ");
                        shortestPath = shortestPath.parent;
                    }
                    sb.insert(0, startCity.getCity() + " -> ");
                    return sb.toString();
                } else {
                    return "No path found";
                }
            }
        }

