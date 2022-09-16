package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.students.model.Student;

import java.util.List;

@Service
public class StudentService {
	private final StudentRepository repository;

	@Autowired
	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}


	public List<Student> getStudents() {
		return repository.findAll();
	}
}
