package com.mongodb.quickstart;

import com.mongodb.quickstart.models.Grade;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

@Component
public class Delete {

    @Autowired
    private StudentRepository repository;

    public void run() {
        // Delete one document
        Grade grade = repository.findFirstByStudentId(10000d);
        if (grade != null) {
            repository.delete(grade);
            System.out.println("Deleted grade: " + grade);
        }

        // Find and delete one document
        grade = repository.findFirstByStudentId(10002d);
        if (grade != null) {
            repository.delete(grade);
            System.out.println("Deleted grade: " + grade);
        }

        // Delete many documents
        repository.deleteAll(repository.findByStudentIdGreaterThanEqual(10000d));
        System.out.println("Deleted all grades with student_id >= 10000.");

        // Drop entire collection
        repository.deleteAll();
        System.out.println("Deleted the entire grades collection.");
    }
}