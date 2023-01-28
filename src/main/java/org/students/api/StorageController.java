package org.students.api;

import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.students.api.dto.StudentFilterDto;
import org.students.model.Student;
import org.students.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${server.basePrefixUrl}")
public class StorageController {

    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(@ParameterObject StudentFilterDto studentFilterDto) {
        return studentService.getStudents(studentFilterDto);
    }

}
