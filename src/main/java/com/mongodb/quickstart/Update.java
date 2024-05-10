package com.mongodb.quickstart;

import com.mongodb.quickstart.models.Grade;
import com.mongodb.quickstart.models.Score;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class Update {

    @Autowired
    private StudentRepository repository;

    public void run() {
        // Update one document by adding a comment
        Grade grade = repository.findByStudentId(10000d);
        if (grade != null) {
            Grade updatedGrade = repository.save(grade);
            System.out.println("Grade updated: " + updatedGrade);
        }

        // Upsert a document
        grade = repository.findByStudentIdAndClassId(10002d, 10d);
        if (grade == null) {
            grade = new Grade()
                    .setId(new ObjectId())
                    .setStudentId(10002d)
                    .setClassId(10d)
                    .setScores(List.of(new Score().setType("homework").setScore(50d)))
                    .setComment("You will learn a lot if you read the MongoDB blog!");
        } else {
            grade.getScores().add(new Score().setType("quiz").setScore(70d));
        }
        Grade upsertedGrade = repository.save(grade);
        System.out.println("Upserted grade: " + upsertedGrade);

        // Update many documents
        List<Grade> grades = repository.findByStudentIdGreaterThanEqual(10001d);
        repository.saveAll(grades);
        System.out.println("Updated all grades with student_id >= 10001.");

        // Find and update
        grade = repository.findByStudentId(10000d);
        if (grade != null) {
            Grade updated = repository.save(grade);
            System.out.println("Updated grade after finding: " + updated);
        }
    }
}