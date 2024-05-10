package com.mongodb.quickstart;

import com.mongodb.quickstart.models.Grade;
import com.mongodb.quickstart.models.Score;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Create {

    @Autowired
    private StudentRepository repository;

    private static final Random rand = new Random();

    public void run() {
        // Insert one document
        Grade grade1 = new Grade()
                .setId(new ObjectId())
                .setStudentId(10000d)
                .setClassId(1d)
                .setScores(generateScores());
        repository.save(grade1);
        System.out.println("One grade inserted for studentId 10000.");

        // Insert many documents
        List<Grade> grades = new ArrayList<>();
        for (double classId = 1d; classId <= 10d; classId++) {
            grades.add(new Grade()
                    .setId(new ObjectId())
                    .setStudentId(10001d)
                    .setClassId(classId)
                    .setScores(generateScores()));
        }
        repository.saveAll(grades);
        System.out.println("Ten grades inserted for studentId 10001.");
    }

    private static List<Score> generateScores() {
        return List.of(new Score().setType("exam").setScore(rand.nextDouble() * 100),
                new Score().setType("quiz").setScore(rand.nextDouble() * 100),
                new Score().setType("homework").setScore(rand.nextDouble() * 100),
                new Score().setType("homework").setScore(rand.nextDouble() * 100));
    }
}