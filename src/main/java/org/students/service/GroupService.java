package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.students.exceptions.GroupNotFoundException;
import org.students.model.Group;

import java.util.List;

@Service
public class GroupService {
	private final GroupRepository groupRepository;

	@Autowired
	public GroupService(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}


	public List<Group> getGroups() {
		return groupRepository.findAll();
	}

	public void addGroup(Group group) {
		boolean exists = groupRepository.existsById(group.getId());
		if (!exists) {
			groupRepository.save(group);
		}
	}

	public Group findById(Long groupId) {
		if (groupRepository.existsById(groupId)) {
			return groupRepository.findGroupById(groupId);
		} else {
			throw new GroupNotFoundException("Group with id " + groupId + " not found");
		}
	}
}
