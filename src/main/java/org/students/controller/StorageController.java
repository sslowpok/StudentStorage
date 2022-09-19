package org.students.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.students.model.Discipline;
import org.students.model.Grade;
import org.students.model.Group;
import org.students.model.Student;
import org.students.service.DisciplineService;
import org.students.service.GradeService;
import org.students.service.GroupService;
import org.students.service.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/storage")
public class StorageController {
	private final StudentService studentService;
	private final GroupService groupService;
	private final DisciplineService disciplineService;
	private final GradeService gradeService;

	private Map<Long, List<Student>> groupStudentMap = new HashMap<>();

	@Autowired
	public StorageController(StudentService studentService, GroupService groupService, DisciplineService disciplineService, GradeService gradeService) {
		this.studentService = studentService;
		this.groupService = groupService;
		this.disciplineService = disciplineService;
		this.gradeService = gradeService;
	}

	@Operation(summary = "Get list of students. Parameters: name, surname, age")
	@GetMapping(path = "students")
	public List<Student> getStudents(
			@RequestParam(required = false) String searchBy,
			@RequestParam(required = false) String searchByParameter,
			@RequestParam(required = false) String sortBy
			) {

		return studentService.getStudents(searchBy, searchByParameter, sortBy);
	}

	@Operation(summary = "Add new student")
	@PostMapping(path = "students/new")
	public void addStudent(@RequestBody Student student,
						   @RequestParam(required = false) Long groupId) {

//		TODO: handle invalid groupId

		studentService.addStudent(student, groupId);
		if (groupStudentMap.containsKey(groupId)) {
			groupStudentMap.get(groupId).add(student);
		}

	}

	@Operation(summary = "Get student by id")
	@GetMapping(path = "students/{id}")
	public Student getStudentById(@PathVariable("id") Long id) {
		return studentService.getStudentById(id);
	}

	@Operation(summary = "Get students by group id (does not work)")
	@GetMapping(path = "groups/{groupId}")
	public List<Student> getStudentByGroupId(@PathVariable("groupId") Long groupId) {
		System.out.println(groupStudentMap.get(groupId));
		return groupStudentMap.get(groupId);
	}

	@Operation(summary = "get list of groups")
	@GetMapping(path = "groups")
	public List<Group> getGroups() {
		return groupService.getGroups();
	}

	@Operation(summary = "Add new group")
	@PostMapping(path = "groups/new")
	public void addGroup(@RequestBody Group group) {
		groupService.addGroup(group);
		groupStudentMap.put(group.getId(), new ArrayList<>());
	}

	@Operation(summary = "Get list of grades")
	@GetMapping(path = "grades")
	public List<Grade> getGrades() {
		return gradeService.getGrades();
	}

	@Operation(summary = "Add new grade")
	@PostMapping(path = "grades/new")
	public void addGrade(@RequestBody Grade grade) {
		gradeService.addGrade(grade);
	}

	@Operation(summary = "Get list of disciplines")
	@GetMapping(path = "disciplines")
	public List<Discipline> getDisciplines() {
		return disciplineService.getDisciplines();
	}

	@Operation(summary = "Add new discipline")
	@PostMapping(path = "disciplines/new")
	public void addDiscipline(@RequestBody Discipline discipline) {
		disciplineService.addDiscipline(discipline);
	}


}
