package org.students.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.students.model.Grade;
import org.students.model.Student;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

	List<Grade> findAllByStudentId(Long studentId);
}
