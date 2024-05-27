package com.mongodb.quickstart;

import com.mongodb.quickstart.models.Grade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Grade, String> {
	Grade findFirstByStudentId(Double studentId);
	List<Grade> findByStudentIdGreaterThanEqual(Double studentId);
	List<Grade> findByStudentIdAndClassIdLessThanEqual(Double studentId, Double classId);
	Grade findByStudentIdAndClassId(Double studentId, Double classId);
}