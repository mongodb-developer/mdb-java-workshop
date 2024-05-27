package com.mongodb.quickstart;

import com.mongodb.quickstart.models.Grade;
import com.mongodb.quickstart.models.Score;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MappingPOJO{

    @Autowired
    private StudentRepository repository;

    public void run() {
        // Create a new grade
        Grade newGrade = null;
        
        
        //
        // add your code here
        //
        
        
        repository.save(newGrade);
        System.out.println("Grade inserted: " + newGrade);

        // Find this grade
        Grade grade = repository.findFirstByStudentId(10003d);
        System.out.println("Grade found: " + (grade != null ? grade : "No data found"));

        // Update this grade by adding an exam grade
        List<Score> newScores = new ArrayList<>(grade.getScores());
        newScores.add(new Score().setType("exam").setScore(42d));
        grade.setScores(newScores);
        Grade updatedGrade = repository.save(grade);
        System.out.println("Grade updated: " + updatedGrade);

        // Delete this grade
        repository.deleteById(updatedGrade.getId().toString());
        System.out.println("Grade deleted.");
    }
}