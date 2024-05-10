package com.mongodb.quickstart;

import com.mongodb.quickstart.models.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Read {

    @Autowired
    private StudentRepository repository;

    public void run() {
        try {
            // Find a grade by student ID
            Grade grade = repository.findByStudentId(10000d);
            System.out.println("Student 1 (via Repository): " + (grade != null ? grade : "No data found"));

            // Find all grades with student IDs greater than or equal to 10000
            List<Grade> gradesList = repository.findByStudentIdGreaterThanEqual(10000d);
            System.out.println("Student list with a cursor:");
            for (Grade student : gradesList) {
                System.out.println(student);
            }

            // Find all grades by student ID and limit by class ID
            List<Grade> docs = repository.findByStudentIdAndClassIdLessThanEqual(10001d, 5d);
            System.out.println("Student sorted, skipped, limited, and projected:");
            for (Grade student : docs) {
                System.out.println(student);
            }
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}