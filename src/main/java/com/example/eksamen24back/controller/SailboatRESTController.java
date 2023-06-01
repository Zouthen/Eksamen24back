package com.example.eksamen24back.controller;

import com.example.eksamen24back.model.Race;
import com.example.eksamen24back.model.Sailboat;
import com.example.eksamen24back.repository.SailboatRepository;
import com.example.eksamen24back.service.SailboatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class SailboatRESTController {

    @Autowired
    SailboatService sailboatService;

    @GetMapping("/sailboats")
    public List<Sailboat> getAllSailboats() {
        return sailboatService.getAllSailboats();
    }

    @PostMapping("/sailboat")
    public ResponseEntity<Sailboat> createSailboat(@RequestBody Sailboat sailboat) {
        Sailboat newSailboat = sailboatService.createSailboat(sailboat);
        return new ResponseEntity<>(newSailboat, HttpStatus.CREATED);
    }

    @DeleteMapping("/sailboat/{id}")
    public ResponseEntity<Sailboat> deleteSailboat(@PathVariable Integer id) {
        sailboatService.deleteSailboat(id);
        return null;
    }

    @PostMapping("/addPointsToSailboat/{sailboatid}/{points}")
    public ResponseEntity<Sailboat> addPointsToSailboat(@PathVariable Map<String, String> pathVarsMap){
        int sailboatid = Integer.parseInt(pathVarsMap.get("sailboatid"));
        String points = pathVarsMap.get("points");

        sailboatService.addPointsToSailboat(sailboatid, points);
        return null;
    }

}
