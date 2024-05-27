package com.mongodb.quickstart;

import com.mongodb.quickstart.models.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.stereotype.Component;

@Component
public class Delete {

    @Autowired
    private StudentRepository repository;

    public void run() {
        try {
            // Delete one document
            Grade grade = repository.findFirstByStudentId(10000d);
            if (grade != null) {

            	// add your solution here
            	
                System.out.println("Deleted grade: " + grade);
            } else {
                System.out.println("No grade found to delete for studentId 10000.");
            }
        } catch (Exception e) {
            System.err.println("Failed to delete grade for studentId 10000: " + e.getMessage());
        }

        try {
            // Find and delete one document
            Grade grade = repository.findFirstByStudentId(10002d);
            if (grade != null) {

            	// add your solution here
            	
                System.out.println("Deleted grade: " + grade);
            } else {
                System.out.println("No grade found to delete for studentId 10002.");
            }
        } catch (Exception e) {
            System.err.println("Failed to delete grade for studentId 10002: " + e.getMessage());
        }

        try {
            // Delete many documents
        	
        	// add your solution here
        	
            System.out.println("Deleted all grades with student_id >= 10000.");
        } catch (Exception e) {
            System.err.println("Failed to delete multiple grades: " + e.getMessage());
        }
    }
}
