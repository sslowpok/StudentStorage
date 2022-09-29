package org.students.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.students.model.Student;

import java.util.List;

//@AutoConfigureMockMvc
@SpringBootTest
//@WebMvcTest
class StudentServiceTest {
//    @Autowired
//    private MockMvc mockMvc;
    List<Student> EXPECTED_FIND_ALL = List.of(
            new Student(1L, "Wade", "Allen", 25, 1L),
            new Student(2L, "Dave", "Lopez", 31, 1L),
            new Student(3L, "Riley", "Long", 17, 2L),
            new Student(4L, "David", "Jones", 31, 3L)
            );

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceTest(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    void getStudentsTest() {
        Assertions.assertEquals(EXPECTED_FIND_ALL, studentRepository.findAll());
    }

//    @Test
//    void addStudentTest() {
//        Student testStudent = new Student("testName", "TestSurname", 100);
//        studentRepository.save(testStudent);
//
//    }



}