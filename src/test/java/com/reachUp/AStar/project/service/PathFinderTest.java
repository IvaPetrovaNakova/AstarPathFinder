package com.reachUp.AStar.project.service;

import com.reachUp.AStar.project.SearchProblem;
import com.reachUp.AStar.project.entity.City;
import com.reachUp.AStar.project.entity.Node;
import com.reachUp.AStar.project.entity.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


/**
 * In this example, I create a SearchProblem object and
 * set its start and goal states, then add some paths to it.
 * Create a PathFinder object and call its solve() method
 * with the search problem as input.
 *
 * In the JUnit test, I check if the result of
 * solve() method is valid. If the first check result
 * is not null, which means that a path from the start to the
 * goal state has been found. I check then if the state of the
 * result node is the goal state, and if the path cost of the
 * result node is equal to the expected cost (in this case, 394).
 * If all these assertions pass, the JUnit test passes.
 * If any of them fail, the test fails and an error message is displayed.
 */
public class PathFinderTest {

    @Test
    public void testSolve() {
        // create a search problem and set the start and goal states
        SearchProblem prblm = new SearchProblem(new City("Montana"), new City("Burgas"));

        // add some paths to the search problem
          prblm.addPath(new Path(new City("Montana"), new City("Pleven"), 106));
          prblm.addPath(new Path(new City("Pleven"), new City("Shumen"), 173));
          prblm.addPath(new Path(new City("Shumen"), new City("Burgas"), 115));

        // create a solver and run solve() method
        PathFinder solver = new PathFinder();
        Node result = solver.solve(prblm);

        // check if the result is valid
        assertNotNull(result);
        Assertions.assertEquals(new City("Burgas"), result.state);
        Assertions.assertEquals(394, result.pathCost);
    }
}
