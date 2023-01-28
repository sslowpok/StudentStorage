package org.students.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.students.api.dto.student.PageStudentDto;
import org.students.api.dto.student.StudentFilterDto;
import org.students.exception.StudentNotFoundException;
import org.students.model.Student;
import org.students.repository.StudentRepository;
import org.students.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public PageStudentDto getStudents(StudentFilterDto studentFilterDto) {
        var result = studentRepository.findAll(
//                getStudentSpecs()
        ); // todo: add filtering


        return null;
    }

    private Specification<Student> getStudentSpecs(StudentFilterDto studentFilterDto) {
        Specification<Student> isDeletedSpec = (root, query, cb) -> cb.and(cb.isFalse(root.get("isDeleted")));
        if (studentFilterDto.getSearch() != null && !studentFilterDto.getSearch().isEmpty()) {
            Specification<Student> searchSpec = (root, query, cb) -> cb.or(
                    studentFilterDto.isExact() ? cb.equal(cb.lower(root.get("firstName")), studentFilterDto.getSearch().toLowerCase())
                            : cb.like(cb.lower(root.get("firstName")), "%" + studentFilterDto.getSearch().toLowerCase() + "%"),
                    studentFilterDto.isExact() ? cb.equal(cb.lower(root.get("lastName")), studentFilterDto.getSearch().toLowerCase())
                            : cb.like(cb.lower(root.get("lastName")), "%" + studentFilterDto.getSearch().toLowerCase() + "%"),
                    studentFilterDto.isExact() ? cb.equal(cb.lower(root.get("age")), studentFilterDto.getSearch().toLowerCase())
                            : cb.like(cb.lower(root.get("age")), "%" + studentFilterDto.getSearch().toLowerCase() + "%")
            );
        }

//        return isDeletedSpec.and();
        return null;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student with id " + id + " not found"));
    }

}
