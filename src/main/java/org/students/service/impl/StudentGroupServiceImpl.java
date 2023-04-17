package org.students.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.students.api.dto.mapper.StudentGroupMapper;
import org.students.api.dto.studentgroup.StudentGroupResponse;
import org.students.model.StudentGroup;
import org.students.repository.StudentGroupRepository;
import org.students.service.StudentGroupService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentGroupServiceImpl implements StudentGroupService {

	private final StudentGroupRepository studentGroupRepository;

	private final StudentGroupMapper studentGroupMapper;

	@Override
	public List<StudentGroupResponse> getGroups() {
		List<StudentGroup> list = studentGroupRepository.findAll();
		return studentGroupMapper.listEntityToResponse(list);
	}

	@Override
	public StudentGroupResponse getGroupById(Long id) {
		StudentGroup entity = studentGroupRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return studentGroupMapper.entityToResponse(entity);
	}


}
