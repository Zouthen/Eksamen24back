package com.example.eksamen24back.controller;

import com.example.eksamen24back.model.TestModel;
import com.example.eksamen24back.repository.TestRepository;
import com.example.eksamen24back.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class TestRESTController {

    @Autowired
    TestService testService;

    @GetMapping("/testmodels")
    public List<TestModel> getAllTestModel() {
        return testService.getAllTestModels();
    }

    @PostMapping("/testmodel")
    public ResponseEntity<TestModel> createTestModel(@RequestBody TestModel testModel) {
        TestModel newTestModel = testService.createTestModel(testModel);
        return new ResponseEntity<>(newTestModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/testmodel/{id}")
    public ResponseEntity<TestModel> deleteTestModel(@PathVariable Integer id)
    {
        testService.deleteTestModel(id);
        return null;
    }

    @GetMapping("/testmodel/{id}")
    public ResponseEntity<TestModel> getTestModelById(@PathVariable("id") Integer id) {
        TestModel testModel = testService.getTestModelById(id);
        return new ResponseEntity<>(testModel, HttpStatus.OK);
    }

    /*
    kodeforsøg der ikke virker


hører til forsøg 1

    @PostMapping("editTestModel/{id}")
    public ResponseEntity<TestModel> createTestModelWithID(@PathVariable("id") Integer id, @RequestBody TestModel testModel) {
        int tempID = id;
        return new ResponseEntity<>(testService.editMovie(tempID,testModel), HttpStatus.OK);
        testService.editMovie(tempID,testModel);
        testService.deleteTestModel(id);
        //TestModel newTestModel = testService.createTestModelWithID(testModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


  hører til forsøg 2

    edit metode.. virker ikke endnu
    @PostMapping("/editTestModel")
    public ResponseEntity<String> updateTestModel(@RequestBody TestModelDTO testModel) {
        System.out.println("vi er i controller updateTestModel");
        return testService.updateTestModel(testModel);
        //return new ResponseEntity<>(testService.updateTestModel(movie, ), HttpStatus.OK);
    }

     */






}
