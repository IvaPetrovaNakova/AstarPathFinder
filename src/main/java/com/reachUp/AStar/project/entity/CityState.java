package com.reachUp.AStar.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city_state")
public class CityState {

    @Id
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )
    @Column(name = "city_id")
    private Long Id;

    @Column(
            name = "city_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
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
