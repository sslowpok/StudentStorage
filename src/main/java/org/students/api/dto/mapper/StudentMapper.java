package org.students.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.students.api.dto.student.StudentAddRequest;
import org.students.api.dto.student.StudentResponse;
import org.students.api.dto.student.StudentUpdateRequest;
import org.students.model.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

	StudentResponse entityToResponse(Student student);

	List<StudentResponse> listEntitiesToResponse(List<Student> list);

	Student postRequestToEntity(StudentAddRequest request);

	Student putRequestToEntity(StudentUpdateRequest request);

	void merge(@MappingTarget Student entity, Student request);

}
