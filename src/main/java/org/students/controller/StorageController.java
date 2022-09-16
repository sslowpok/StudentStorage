package org.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.students.model.Group;
import org.students.model.Student;
import org.students.service.DisciplineService;
import org.students.service.GroupService;
import org.students.service.StudentService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/storage")
public class StorageController {
	private final StudentService studentService;
	private final GroupService groupService;
	private final DisciplineService disciplineService;

	@Autowired
	public StorageController(StudentService studentService, GroupService groupService, DisciplineService disciplineService) {
		this.studentService = studentService;
		this.groupService = groupService;
		this.disciplineService = disciplineService;
	}

	@GetMapping(path = "students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping(path = "groups")
	public List<Group> getGroups() {
		return groupService.getGroups();
	}
}
