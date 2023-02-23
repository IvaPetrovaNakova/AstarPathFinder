package com.reachUp.AStar.project.entity;

import com.reachUp.AStar.project.entity.CityState;

public class Action {

    public CityState child;
    public int cost;
    public int travelTime;
    public int maxLimitedSpeed;

    /**
     * No arguments constructor
     */
    public Action(){}

    /**
     * Constructor
     * @param child gets possible connected cities
     * @param c gets distance in kilometers
     */
    public Action(CityState child, int c) {
        this.child = child;
        this.cost = c;
    }

    /**
     * Constructor
     * @param child gets possible connected cities
     * @param c gets distance in kilometers
     * @param travelTime gets travel time in minutes
     * @param maxLimitedSpeed gets the max limited speed on the road
     */
    public Action(
            CityState child,
            int c,
            int travelTime,
            int maxLimitedSpeed) {
        this.child = child;
        this.cost = c;
        this.travelTime = travelTime;
        this.maxLimitedSpeed = maxLimitedSpeed;
    }

    @Override
    public String toString() {
        return (child.toString() + " " + cost);
    }
}
