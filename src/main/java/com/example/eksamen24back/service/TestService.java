package com.example.eksamen24back.service;

import com.example.eksamen24back.model.TestModel;
import com.example.eksamen24back.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;


    public List<TestModel> getAllTestModels() {
        return testRepository.findAll();
    }

    public TestModel createTestModel(TestModel testModel) {
        return testRepository.save(testModel);
    }

    public TestModel getTestModelById(Integer id) {
        return testRepository.findById(id).orElse(null);
    }

    public void deleteTestModel(Integer id) {
        testRepository.deleteById(id);
    }



/*
kodeforsøg der ikke virker

        forsøg 1

public void createTestModelWithID(int id, TestModel testModel) {
        System.out.println("vi er i service createTestModelWithID");
        testModel.setId(id);
        testModel.setName(testModel.getName());
        testModel.setAge(testModel.getAge());
        testModel.setEmail(testModel.getEmail());
        testRepository.save(testModel);
    }

    public ResponseEntity<String> editMovie (int id, TestModel testModel) {

        System.out.println("vi er i service editMovie");
        testModel.setId(id);
        testModel.setName(testModel.getName());
        testModel.setAge(testModel.getAge());
        testModel.setEmail(testModel.getEmail());

        testRepository.save(testModel);


        return ResponseEntity.ok("testModel edited");
    }

    forsøg 2

    public ResponseEntity<String> updateTestModel(@RequestBody TestModelDTO testModelDTO) {
        System.out.println("vi er i service updateTestModel");
        System.out.println(testRepository.findTestModelById(testModelDTO.getId()).get());
        TestModel testModel = testRepository.findTestModelById(testModelDTO.getId()).get();
        testModel.setName(testModelDTO.getName());
        testModel.setAge(testModelDTO.getAge());
        testModel.setEmail(testModelDTO.getEmail());

        testRepository.save(testModel);

        return ResponseEntity.ok("TestModel updated");
    }

 */
}
