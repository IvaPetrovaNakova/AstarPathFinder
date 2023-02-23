package com.reachUp.AStar.project;


import com.reachUp.AStar.project.entity.Node;
import com.reachUp.AStar.project.service.PathFinder;

public class Main {
    public static void main(String[] args) {
        SearchProblem prblm = new SearchProblem("Montana", "Burgas");
        PathFinder path = new PathFinder();
        Node node = path.solve(prblm);
        node.printBackTrace();
    }
}
