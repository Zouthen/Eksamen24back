package com.example.eksamen24back.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Sailboat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String boattype;
    private String points;

    @ManyToMany(mappedBy = "sailboats")
    private Set<Race> races = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoattype() {
        return boattype;
    }

    public void setBoattype(String boattype) {
        this.boattype = boattype;
    }

    public String getPoints() {
        return points;
    }
    public void setPoints(String points) {
        this.points = points;
    }
}
