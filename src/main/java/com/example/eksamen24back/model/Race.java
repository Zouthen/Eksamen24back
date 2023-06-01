package com.example.eksamen24back.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int raceNumber;
    private String boattype;



    @ManyToMany
    @JoinTable(
            name = "race_sailboat",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "sailboat_id")
    )


    private Set<Sailboat> sailboats = new HashSet<>();

    public Set<Sailboat> getSailboats() {
        return sailboats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }

    public String getBoattype() {
        return boattype;
    }

    public void setBoattype(String boattype) {
        this.boattype = boattype;
    }
}
