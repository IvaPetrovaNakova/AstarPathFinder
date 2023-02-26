package com.reachUp.AStar.project.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "path_state")
public class Path {

    @Id
    @SequenceGenerator(
            name = "path_sequence",
            sequenceName = "path_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "path_sequence"
    )
    @Column(name = "path_id")
    private Long Id;

    @Column(
            name = "city_from",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotBlank(message = "The destination point must be not blank")
    @Length(min = 3, max = 512, message = "The city name must have 3-512 characters")
    public String from;

    @Column(
            name = "city_to",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotBlank(message = "The ending point must be not blank")
    @Length(min = 3, max = 512, message = "The city name must have 3-512 characters")
    public String to;

    @Column(
            name = "travelDistance",
            nullable = false
    )
    @NotBlank(message = "The direct distance cost must not be blank")
    @Min(value = 1, message = "The direct destination must be greater than 0")
    public int cost;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "city_id")
    public City child;

    /**
     * No arguments constructor
     */
    public Path(){}

    /**
     * Constructor
     * @param from gets the starting point
     * @param to gets the ending points
     * @param cost distance in kilometer
     */
    public Path(
            String from,
            String to,
            int cost
    ) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    /**
     * Constructor
     * @param child gets possible connected cities
     * @param c gets distance in kilometers
     */
    public Path(City child, int c) {
        this.child = child;
        this.cost = c;
    }

    @Override
    public String toString() {
        return (child.toString() + " " + cost);
    }
}
