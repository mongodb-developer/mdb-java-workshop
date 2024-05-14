package com.mongodb.quickstart;

import com.mongodb.quickstart.models.Grade;
import com.mongodb.quickstart.models.Score;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Create {

    @Autowired
    private StudentRepository repository;

    private static final Random rand = new Random();

    public void run() {
        try {
            // Insert one document
            Grade grade1 = new Grade()
                    .setId(new ObjectId())
                    .setStudentId(10000d) // Example: Change the student ID as needed
                    .setClassId(1d)       // Example: Change the class ID as needed
                    .setScores(generateScores());
            
         // add your solution here
            
            System.out.println("One grade inserted for studentId 10000.");
        } catch (Exception e) {
            System.err.println("Failed to insert grade for studentId 10000: " + e.getMessage());
        }

        try {
            // Insert many documents
            List<Grade> grades = new ArrayList<>();
            for (double classId = 1d; classId <= 10d; classId++) {
                grades.add(new Grade()
                        .setId(new ObjectId())
                        .setStudentId(10001d)
                        .setClassId(classId)
                        .setScores(generateScores()));
            }
            
         // add your solution here

            System.out.println("Ten grades inserted for studentId 10001.");
        } catch (Exception e) {
            System.err.println("Failed to insert grades for studentId 10001: " + e.getMessage());
        }
    }

    private static List<Score> generateScores() {
        return List.of(new Score().setType("exam").setScore(rand.nextDouble() * 100),
                new Score().setType("quiz").setScore(rand.nextDouble() * 100),
                new Score().setType("homework").setScore(rand.nextDouble() * 100),
                new Score().setType("homework").setScore(rand.nextDouble() * 100));
    }
}