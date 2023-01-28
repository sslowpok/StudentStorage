package org.students.service;

import org.students.api.dto.student.PageStudentDto;
import org.students.api.dto.student.StudentFilterDto;
import org.students.model.Student;

import java.util.List;

public interface StudentService {
    PageStudentDto getStudents(StudentFilterDto studentFilterDto);

    void addStudent(Student student);

    Student getStudentById(Long id);
}
