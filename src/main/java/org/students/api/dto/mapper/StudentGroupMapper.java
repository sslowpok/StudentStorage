package org.students.api.dto.mapper;

import org.mapstruct.Mapper;
import org.students.api.dto.studentgroup.StudentGroupResponse;
import org.students.model.StudentGroup;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentGroupMapper {

	List<StudentGroupResponse> listEntityToResponse(List<StudentGroup> list);

	StudentGroupResponse entityToResponse(StudentGroup group);

}
