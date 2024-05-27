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
        try {
            // Update one document by adding a comment
            Grade grade = repository.findFirstByStudentId(10000d);
            if (grade != null) {
                Grade updatedGrade = null;
                
                //
                // your solution here
                //
                
                System.out.println("Grade updated: " + updatedGrade);
            } else {
                System.out.println("No grade found for studentId 10000.");
            }
        } catch (Exception e) {
            System.err.println("Failed to update grade for studentId 10000: " + e.getMessage());
        }

        try {
            // Upsert a document
        	Grade grade = repository.findByStudentIdAndClassId(10002d, 10d);
        	
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
            
            Grade upsertedGrade = null;
            
            //
            // your solution here
            //
            
            System.out.println("Upserted grade: " + upsertedGrade);
        } catch (Exception e) {
            System.err.println("Failed to upsert grade for studentId 10002: " + e.getMessage());
        }

        try {
            // Update many documents
            List<Grade> grades = repository.findByStudentIdGreaterThanEqual(10001d);
            
            //
            // your solution here
            //
            
            System.out.println("Updated all grades with student_id >= 10001.");
        } catch (Exception e) {
            System.err.println("Failed to update multiple grades: " + e.getMessage());
        }

        try {
            // Find and update
        	Grade grade = repository.findFirstByStudentId(10000d);
            if (grade != null) {
            	Grade updated = null;
            	
            	//
            	// your solution here
            	//
            	
                System.out.println("Updated grade after finding: " + updated);
            } else {
                System.out.println("No grade found for update on studentId 10000.");
            }
        } catch (Exception e) {
            System.err.println("Failed to find and update grade: " + e.getMessage());
        }
    }
}
