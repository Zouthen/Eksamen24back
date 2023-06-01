package com.example.eksamen24back.service;

import com.example.eksamen24back.model.Sailboat;
import com.example.eksamen24back.model.TestModel;
import com.example.eksamen24back.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SailboatService {

    @Autowired
    SailboatRepository sailboatRepository;

    public List<Sailboat> getAllSailboats() {
        return sailboatRepository.findAll();
    }

    public Sailboat createSailboat(Sailboat sailboat) {
        return sailboatRepository.save(sailboat);
    }

    public void deleteSailboat(Integer id) {
        sailboatRepository.deleteById(id);
    }


    public void addPointsToSailboat(int sailboatid, String points) {
        Sailboat sailboat = sailboatRepository.findSailboatById(sailboatid).get();
        sailboat.setPoints(points);
        sailboatRepository.save(sailboat);
    }
}
