package org.students.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.students.api.dto.student.PageStudentDto;
import org.students.api.dto.student.StudentFilterDto;
import org.students.enums.ConditionConnectEnum;
import org.students.exception.StudentNotFoundException;
import org.students.model.Student;
import org.students.repository.StudentRepository;
import org.students.service.StudentService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public PageStudentDto getStudents(StudentFilterDto filter) {
        // todo: add sort
        PageRequest page = PageRequest.of(
                filter.getPage(),
                filter.getSize(),
                Sort.by("id").ascending()
        );
        var result = (filter.getSearch() != null && !filter.getSearch().isBlank()) ?
                studentRepository.findAll(page) :
                studentRepository.findAll(getStudentSpecs(filter), page);
        return PageStudentDto.builder()
                .content(result.getContent().stream()
                        .distinct()
                        .collect(Collectors.toList()))
                .totalPages(result.getTotalPages())
                .build();
    }

    private Specification<Student> getStudentSpecs(StudentFilterDto filter) {
        if (filter.getSearch() != null && !filter.getSearch().isEmpty()) {
            return (root, query, cb) -> cb.or(
                    filter.isExact() ? cb.equal(cb.lower(root.get("firstName")), filter.getSearch().toLowerCase())
                            : cb.like(cb.lower(root.get("firstName")), "%" + filter.getSearch().toLowerCase() + "%"),
                    filter.isExact() ? cb.equal(cb.lower(root.get("lastName")), filter.getSearch().toLowerCase())
                            : cb.like(cb.lower(root.get("lastName")), "%" + filter.getSearch().toLowerCase() + "%"),
                    filter.isExact() ? cb.equal(cb.lower(root.get("age")), filter.getSearch().toLowerCase())
                            : cb.like(cb.lower(root.get("age")), "%" + filter.getSearch().toLowerCase() + "%")
            );
        }
        return Specification.where(null);
    }

//    private Specification<Student> getCondition(ConditionConnectEnum condition, Specification<Student> firstSpec,
//                                                Specification<Student> secondSpec) {
//        if (condition == null || condition == ConditionConnectEnum.OR) {
//            return firstSpec.or(secondSpec);
//        }
//        return firstSpec.and(secondSpec);
//    }
//
//    private Specification<Student> convertMultipleSpecsToSingle(Set<Specification<Student>> spec, ConditionConnectEnum condition) {
//        return spec.stream()
//                .reduce((x, y) -> getCondition(condition, x, y))
//                .orElse(Specification.where(null));
//    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student with id " + id + " not found"));
    }

}
