package com.reachUp.AStar.project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city_state")
public class City {

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

//    @OneToMany(
//            mappedBy = "city_state",
//            orphanRemoval = true,
//            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
//            fetch = FetchType.LAZY
//    )
//    private List<Path> paths = new ArrayList<>();

    /**
     * No arguments constructor
     */
    public City() {
    }

    /**
     * Constructor
     * @param city gets city name
     */
    public City(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.city;
    }

    @Override
    public boolean equals(Object obj) {
        boolean retVal = false;
        if (obj instanceof City) {
            City ptr = (City) obj;
            retVal = ptr.city.equals(this.city);
        }
        return retVal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
