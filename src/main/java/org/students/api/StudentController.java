package org.students.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.students.api.dto.student.StudentAddRequest;
import org.students.api.dto.student.StudentResponse;
import org.students.api.dto.student.StudentUpdateRequest;
import org.students.model.Student;
import org.students.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${server.basePrefixUrl}/students")
public class StudentController {

	private final StudentService studentService;

	@GetMapping
	@Operation(summary = "Get list of students")
	public List<StudentResponse> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("{id}")
	@Operation(summary = "Get student by id")
	public StudentResponse getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@PostMapping
	@Operation(summary = "Add student")
	public StudentResponse addStudent(StudentAddRequest student) {
		return studentService.addStudent(student);
	}

	@PutMapping
	@Operation(summary = "Update student")
	public StudentResponse updateStudent(StudentUpdateRequest request) {
		return studentService.updateStudent(request);
	}

	@DeleteMapping("{id}")
	@Operation(summary = "Delete student by id")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

}