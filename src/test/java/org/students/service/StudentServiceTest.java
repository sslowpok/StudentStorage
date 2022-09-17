package org.students.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.students.model.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class StudentServiceTest {
	@Autowired
	private StudentRepository studentRepositoryForTest;

	List<Student> EXPECTED_GET_STUDENT = List.of(
			new Student(1L, "Wade", "Allen", 25, 1L),
			new Student(2L, "Dave", "Lopez", 31, 1L),
			new Student(3L, "Riley", "Long", 17, 2L)
	);

	@Test
	void getStudentsTest() {
		List<Student> actual = studentRepositoryForTest.findAll();
		Assertions.assertEquals(EXPECTED_GET_STUDENT, actual);
	}


//	@Test
//	void addStudentTest() {
//		Student student = new Student(
//				"TestName",
//				"TestSurname",
//				100,
//				1L);
//		studentRepositoryForTest.save(student);
//		Assertions.assertTrue(studentRepositoryForTest.existsById(student.getId()));
//	}

	@Test
	void getStudentsByGroupIdTest() {
	}

	@Test
	void getStudentByIdTest() {
	}
}