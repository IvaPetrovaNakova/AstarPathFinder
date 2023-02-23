package com.reachUp.AStar.project.service;

import com.reachUp.AStar.project.entity.Action;
import com.reachUp.AStar.project.entity.Node;
import com.reachUp.AStar.project.SearchProblem;
import com.reachUp.AStar.project.entity.CityState;

import java.util.ArrayList;
import java.util.Comparator;                                                                                                                                                                                                                                    
import java.util.PriorityQueue;

/**
 * Class define initialize start node, open list and
 * visited list set (for graph search)
  */
public class PathFinder {

    /**
     *
     * @param prblm
     * @return
     */
    public Node solve(SearchProblem prblm) {

        CityState startState = prblm.getStartState();
        Node selectedNode = null;
        int numNodesPushedToOpenList = 0;

        //OpenList keeps track of those neighbours that need to be examined
        //replace criteria function and previously heuristic comparator
        //within Comparator in PQ calculates the children score itself
        PriorityQueue<Node> openList = new PriorityQueue<>(
                1,
                new Comparator<Node>()
                {
            @Override
            public int compare(Node i, Node j) {
                return
                ((i.pathCost + prblm.heuristic(i.state))
                - (j.pathCost+ prblm.heuristic(j.state)));
            }
        });

        //ClosedList stores cities already visited
        ArrayList<CityState> visitedList = new ArrayList<>();

       // boolean reachGoal = false; //replace with method reachGoal in ProblemSearch
       // City currentPosition = fromCity;// replace with startState
        openList.add(new Node(startState));

        do {
            //select a node from open list for expansion use PriorityQueue
            //insert the node into visited list
            System.out.println("Open list Nodes: " + openList);
            selectedNode = openList.poll();
            if (prblm.reachGoal(selectedNode.state)) { //TODO - if selectedNode != null
                System.out.println(
                        "Number of nodes pushed into the openList: "
                                + numNodesPushedToOpenList);
                System.out.println(
                        "Number of nodes visited before reaching the goal: "
                                + visitedList.size());
                return selectedNode;
            }

            if (!visitedList.contains(selectedNode.state)) {
                visitedList.add(selectedNode.state);
                System.out.println(
                        "Visited list Nodes: "
                                + visitedList);
                ArrayList<Action> children = prblm.getChildren(selectedNode.state);


                for (int i = 0; i < children.size(); i++) {
                    Action currentlyConsidering = children.get(i);
                    Node childNode = new Node(currentlyConsidering.child);
                    childNode.pathCost = selectedNode.pathCost + currentlyConsidering.cost;
                    childNode.parent = selectedNode;
                    System.out.println("Currently considering " + i + ": name -> "
                            + currentlyConsidering.child.city + ", cost -> "
                            + childNode.pathCost + ", heuristic value -> "
                            + prblm.heuristic(currentlyConsidering.child));
                    if (!visitedList.contains(currentlyConsidering.child) && !openList.contains(childNode)) {
                        openList.add(childNode);
                        numNodesPushedToOpenList++;
                    }
                }
                System.out.println("-------------------------------------------------------------------");
            }
            // do reach goal,
            // if true, return current node
            // else insert children obtained from getChildren into openList
        }  while (!openList.isEmpty());
            //if not find the goal return an empty node
            return new Node(new CityState(""));
        }
    }


