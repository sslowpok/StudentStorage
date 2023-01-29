package org.students.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.students.api.dto.student.PageStudentDto;
import org.students.api.dto.student.StudentFilterDto;
import org.students.model.Student;
import org.students.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${server.basePrefixUrl}")
public class StorageController {

    private final StudentService studentService;

    @Operation(summary = "Get page of students")
    @GetMapping("/students")
    public PageStudentDto getStudents(@ParameterObject StudentFilterDto studentFilterDto) {
        return studentService.getStudents(studentFilterDto);
    }

    @Operation()
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/students")
    public void updateStudent(Student student) {

    }

    @DeleteMapping("/students")
    public void deleteStudent(Student student) {

    }

}
