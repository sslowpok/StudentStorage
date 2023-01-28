package org.students.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.students.api.dto.StudentFilterDto;
import org.students.model.Student;
import org.students.repository.StudentRepository;
import org.students.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents(StudentFilterDto studentFilterDto) {
        var result = studentRepository.findAll(

        );


        return null;
    }

    private Specification<Student> getStudentSpecs(StudentFilterDto studentFilterDto) {
        if (studentFilterDto.getSearch() != null && !studentFilterDto.getSearch().isEmpty()) {
            Specification<Student> searchSpec = (root, query, cb) -> {

                

            };
        }


    }

}
