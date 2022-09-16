package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.students.model.Group;

import java.util.List;

@Service
public class GroupService {
	private GroupRepository groupRepository;

	@Autowired
	public GroupService(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}


	public List<Group> getGroups() {
		return groupRepository.findAll();
	}
}
