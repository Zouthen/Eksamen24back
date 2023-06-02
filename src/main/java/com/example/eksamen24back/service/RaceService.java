package com.example.eksamen24back.service;

import com.example.eksamen24back.model.Race;
import com.example.eksamen24back.repository.RaceRepository;
import com.example.eksamen24back.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    SailboatRepository sailboatRepository;

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public Race createRace(Race race) {
        return raceRepository.save(race);
    }

    public void deleteRace(Integer id) {
        raceRepository.deleteById(id);
    }

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public void addSailboatToRace(int raceid, int sailboatid) {
        Race race = raceRepository.findRaceById(raceid).orElse(null);
        race.getSailboats().add(sailboatRepository.findSailboatById(sailboatid).get());
        raceRepository.save(race);
    }

    public List<Race> getAllRacesWithSailboats() {
        List<Race> races = raceRepository.findAll();
        races.removeIf(race -> race.getSailboats().isEmpty());
        return races;
    }

    public void addAllRacesToDB(){
        String boattypeShort = "Shorter than 25 feet";
        String boattypeMedium = "25-40 feet";
        String boattypeLong = "Longer than 40 feet";

        int weeks1 = 1;
        while(weeks1<7){

            Race race1 = new Race();
        race1.setBoattype(boattypeShort);
        race1.setRaceNumber(weeks1);
        raceRepository.save(race1);

            Race race2 = new Race();
        race2.setBoattype(boattypeMedium);
        race2.setRaceNumber(weeks1);
        raceRepository.save(race2);

            Race race3 = new Race();
        race3.setBoattype(boattypeLong);
        race3.setRaceNumber(weeks1);
        raceRepository.save(race3);

            weeks1 = weeks1 + 1;
        }

    }

}
