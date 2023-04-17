package org.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.students.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
