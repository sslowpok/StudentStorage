package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.students.exceptions.IllegalFilterException;
import org.students.exceptions.StudentNotFoundException;
import org.students.model.Grade;
import org.students.model.Student;

import javax.transaction.Transactional;
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

	public List<Student> getStudents(Integer sortBy) {

		if (sortBy == 1) {
			return repository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
		} else if (sortBy == 2) {
			return repository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
		} else if (sortBy == 3) {
			return repository.findAll(Sort.by(Sort.Direction.ASC, "age"));
		} else {
			throw new IllegalFilterException("Invalid filter option");
		}
	}

	public void addStudent(Student student) {
		boolean exists = repository.existsById(student.getId());
		if (!exists) {
			repository.save(student);
		}
	}

	public List<Student> getStudentsByGroupId(Long groupId) {
		return repository.getStudentsByGroupId(groupId);
	}

	public Student getStudentById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(
						"Student with id " + id + " not found"));
	}
}
