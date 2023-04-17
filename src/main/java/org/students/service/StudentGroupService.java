package org.students.service;

import org.students.api.dto.studentgroup.StudentGroupResponse;

import java.util.List;

public interface StudentGroupService {

	List<StudentGroupResponse> getGroups();

	StudentGroupResponse getGroupById(Long id);



}
