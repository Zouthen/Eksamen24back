package com.example.eksamen24back.repository;

import com.example.eksamen24back.model.Race;
import com.example.eksamen24back.model.Sailboat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SailboatRepository extends JpaRepository<Sailboat, Integer> {

    Optional<Sailboat> findSailboatById(int id);
}
