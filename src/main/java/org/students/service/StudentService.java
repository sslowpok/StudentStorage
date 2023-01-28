package org.students.service;

import org.students.api.dto.StudentFilterDto;
import org.students.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents(StudentFilterDto studentFilterDto);
}
