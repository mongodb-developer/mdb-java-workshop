package com.mongodb.quickstart;

import com.mongodb.quickstart.models.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Read {

    @Autowired
    private StudentRepository repository;

    public void run() {
        try {
            // Find grades by student ID
            Grade grade = null;
            
            //
            // add your solution here
            //
            
            System.out.println("Student 1 (via Repository): " + (grade != null ? grade : "No data found"));

        } catch (Exception e) {
            System.err.println("Failed to find a grade by student ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        try {
        	// Find all grades with student IDs greater than or equal to 10000
            List<Grade> gradesList = null;
            
            //
            // add your solution here
            //
            
            System.out.println("Student list with a cursor:");
            for (Grade student : gradesList) {
                System.out.println(student);
            }
        } catch (Exception e) {
        	System.err.println("Failed to find all grades with student IDs greater than or equal to 10000: " + e.getMessage());
            e.printStackTrace();
        }
        
        try {
        	// Find all grades by student ID and limit by class ID
            List<Grade> docs = null;
            
            //
            // add your solution here
            //
            
            System.out.println("Student sorted, skipped, limited, and projected:");
            for (Grade student : docs) {
                System.out.println(student);
            }
        } catch (Exception e) {
        	System.err.println("Failed to find all grades by student ID and limit by class ID: " + e.getMessage());
            e.printStackTrace();
        }
    }
}