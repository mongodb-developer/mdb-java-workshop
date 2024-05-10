package com.mongodb.quickstart.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "grades")
public class Grade {
    @Id
    private ObjectId id;
    private Double studentId;
    private Double classId;
    private List<Score> scores;
    private String comment;

    public ObjectId getId() {
        return id;
    }

    public Grade setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public Double getStudentId() {
        return studentId;
    }

    public Grade setStudentId(Double studentId) {
        this.studentId = studentId;
        return this;
    }

    public Double getClassId() {
        return classId;
    }

    public Grade setClassId(Double classId) {
        this.classId = classId;
        return this;
    }

    public List<Score> getScores() {
        return scores;
    }

    public Grade setScores(List<Score> scores) {
        this.scores = scores;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Grade setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", classId=" + classId +
                ", scores=" + scores +
                ", comment='" + comment + '\'' +
                '}';
    }
}
