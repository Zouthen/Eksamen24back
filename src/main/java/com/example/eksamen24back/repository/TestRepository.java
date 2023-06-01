package com.example.eksamen24back.repository;

import com.example.eksamen24back.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<TestModel, Integer> {

    Optional<TestModel> findTestModelById(int id);
}
