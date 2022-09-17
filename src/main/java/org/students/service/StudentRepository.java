package org.students.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.students.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//	@Query("SELECT a FROM Student a WHERE a.id=?")
	List<Student> getStudentsByGroupId(Long groupId);

	List<Student> getStudentByGroupId(Long groupId);
}
