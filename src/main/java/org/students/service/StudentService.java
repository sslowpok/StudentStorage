package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.students.exceptions.StudentNotFoundException;
import org.students.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
	private final StudentRepository repository;
	private List<Student> cachedStudentList;
	boolean isUpdated = true;

	@Autowired
	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public List<Student> getStudents(String searchBy, String searchByParameter,
									 String sortBy) {
		if (isUpdated) {
			cachedStudentList = repository.findAll();
			isUpdated = false;
		}
		return sorter(searcher(searchBy, searchByParameter), sortBy);
	}

	public void addStudent(Student student) {
		Optional<Student> optionalStudent = repository.findById(student.getId());
		if (optionalStudent.isPresent()) {
			throw new IllegalStateException(
					"Student with id " + student.getId() + " already exists");
		}
		repository.save(student);
	}

	public Student getStudentById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(
						"Student with id " + id + " not found"));
	}

	public List<Student> getStudentsByGroupId(Long groupId) {
		return repository.findAllByGroupId(groupId);
	}

	private List<Student> searcher(String searchBy, String parameter) {
		if (searchBy != null) {
			if (searchBy.equalsIgnoreCase("name")) {
				return cachedStudentList.stream()
						.filter(student -> student.getFirstName().equalsIgnoreCase(parameter))
						.collect(Collectors.toList());
			} else if (searchBy.equalsIgnoreCase("surname")) {
				return cachedStudentList.stream()
						.filter(student -> student.getLastName().equalsIgnoreCase(parameter))
						.collect(Collectors.toList());
			} else if (searchBy.equalsIgnoreCase("age")) {
				return cachedStudentList.stream()
						.filter(student -> student.getAge() == Integer.parseInt(parameter))
						.collect(Collectors.toList());
			}
		}
		return cachedStudentList;
	}

	private List<Student> sorter(List<Student> afterSearch, String sortBy) {
		if (sortBy != null) {
			if (sortBy.equalsIgnoreCase("name")) {
				return afterSearch.stream()
						.sorted(Comparator.comparing(Student::getFirstName))
						.collect(Collectors.toList());
			} else if (sortBy.equalsIgnoreCase("surname")) {
				return afterSearch.stream()
						.sorted(Comparator.comparing(Student::getLastName))
						.collect(Collectors.toList());
			} else if (sortBy.equalsIgnoreCase("age")) {
				return afterSearch.stream()
						.sorted(Comparator.comparing(Student::getAge))
						.collect(Collectors.toList());
			} else {
				throw new IllegalStateException("Invalid parameter");
			}
		}
		return afterSearch;
	}

}
