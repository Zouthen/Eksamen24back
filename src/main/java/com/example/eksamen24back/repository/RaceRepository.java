package com.example.eksamen24back.repository;

import com.example.eksamen24back.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {

    Optional<Race> findRaceById(int id);

}
