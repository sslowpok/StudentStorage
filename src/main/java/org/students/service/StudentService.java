package org.students.service;

import org.students.api.dto.student.StudentAddRequest;
import org.students.api.dto.student.StudentResponse;
import org.students.api.dto.student.StudentUpdateRequest;

import java.util.List;

public interface StudentService {

	List<StudentResponse> getStudents();

	StudentResponse getStudentById(Long id);

	StudentResponse addStudent(StudentAddRequest request);

	StudentResponse updateStudent(StudentUpdateRequest request);

	void deleteStudent(Long id);

}
