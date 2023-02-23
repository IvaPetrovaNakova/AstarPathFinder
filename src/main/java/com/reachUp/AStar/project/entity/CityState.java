package com.reachUp.AStar.project.entity;

import javax.persistence.*;
import java.util.Objects;


public class CityState {


    private Long Id;
    public String city;
    // private double longitude;
    // private double latitude;
    // private String prominance;

    public CityState() {
    }

    public CityState(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.city;
    }

    @Override
    public boolean equals(Object obj) {
        boolean retVal = false;
        if (obj instanceof CityState) {
            CityState ptr = (CityState) obj;
            retVal = ptr.city.equals(this.city);
        }
        return retVal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
