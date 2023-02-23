package com.reachUp.AStar.project.entity;

public class Node {

    public CityState state;
    public int pathCost;
    public Node parent;

    /**
     * No argument constructor
     */
    public Node(){}

    /**
     * Constructor
     * @param stValue
     */
    public Node(CityState stValue) {
        this.state = stValue;
        this.pathCost = 0;
        this.parent = null;
    }

    /**
     * Print the back path
     */
    public void printBackTrace() {
        if (parent != null)
            parent.printBackTrace();
        System.out.println("\t" + this.state.city + "\t" + pathCost);
    }

    @Override
    public boolean equals(Object o){
        boolean retVal = false;
        if (o instanceof Node){
            Node ptr = (Node) o;
            retVal = ptr.state == this.state;
        }
        return retVal;
    }

    @Override
    public String toString() {
        return this.state.city;
    }
}
