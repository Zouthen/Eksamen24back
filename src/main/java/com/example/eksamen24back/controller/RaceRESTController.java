package com.example.eksamen24back.controller;

import com.example.eksamen24back.model.Race;
import com.example.eksamen24back.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class RaceRESTController {

    @Autowired
    RaceService raceService;

    @GetMapping("/races")
    public List<Race> getAllRaces() {
        return raceService.getAllRaces();
    }

    @PostMapping("/race")
    public ResponseEntity<Race> createRace(@RequestBody Race race){
        Race newRace = raceService.createRace(race);
        return new ResponseEntity<>(newRace, HttpStatus.CREATED);
    }

    @DeleteMapping("/race/{id}")
    public ResponseEntity<Race> deleteRace(@PathVariable Integer id) {
        raceService.deleteRace(id);
        return null;
    }

    @PostMapping("/addSailboatToRace/{raceid}/{sailboatid}")
    public ResponseEntity<Race> addSailboatToRace(@PathVariable Map<String, String> pathVarsMap){
        int raceid = Integer.parseInt(pathVarsMap.get("raceid"));
        int sailboatid = Integer.parseInt(pathVarsMap.get("sailboatid"));
        raceService.addSailboatToRace(raceid, sailboatid);
        return null;
    }
    @GetMapping("/racesWithSailboats")
    public List<Race> getAllRacesWithSailboats() {
        return raceService.getAllRacesWithSailboats();
    }

    @PostMapping("/createAllRaces")
    public ResponseEntity<Race> createAllRaces(){
        raceService.addAllRacesToDB();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
