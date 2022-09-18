package org.students.controller;

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

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/storage")
public class StorageController {
	private final StudentService studentService;
	private final GroupService groupService;
	private final DisciplineService disciplineService;
	private final GradeService gradeService;

	@Autowired
	public StorageController(StudentService studentService, GroupService groupService, DisciplineService disciplineService, GradeService gradeService) {
		this.studentService = studentService;
		this.groupService = groupService;
		this.disciplineService = disciplineService;
		this.gradeService = gradeService;
	}

	@GetMapping(path = "students")
	public List<Student> getStudents(
			@RequestParam(required = false) String searchBy,
			@RequestParam(required = false) String searchByParameter,
			@RequestParam(required = false) String sortBy
			) {

		return studentService.getStudents(searchBy, searchByParameter, sortBy);
	}

	@PostMapping(path = "students/new")
	public void addStudent(@RequestBody Student student,
						   @RequestParam(required = false) Long groupId) {
		if (groupId != null) {
			student.setGroup(groupService.findById(groupId));
		}
		studentService.addStudent(student, groupId);
	}

	@GetMapping(path = "students/{id}")
	public Student getStudentById(@PathVariable("id") Long id) {
		return studentService.getStudentById(id);
	}

	@GetMapping(path = "groups")
	public List<Group> getGroups() {
		return groupService.getGroups();
	}

	@PostMapping(path = "groups/new")
	public void addGroup(@RequestBody Group group) {
		groupService.addGroup(group);
	}

	@GetMapping(path = "grades")
	public List<Grade> getGrades() {
		return gradeService.getGrades();
	}

	@PostMapping(path = "grades/new")
	public void addGrade(@RequestBody Grade grade) {
		gradeService.addGrade(grade);
	}

	@GetMapping("grades/{studentId}")
	public List<Grade> getStudentGrades(@PathVariable("studentId") Long studentId) {
		return gradeService.getStudentGrades(studentId);
	}

	@GetMapping(path = "disciplines")
	public List<Discipline> getDisciplines() {
		return disciplineService.getDisciplines();
	}

	@PostMapping(path = "disciplines/new")
	public void addDiscipline(@RequestBody Discipline discipline) {
		disciplineService.addDiscipline(discipline);
	}


//	@GetMapping(path = "students/{groupId}")
//	public List<Student> getStudentsByGroupId(@PathVariable("groupId") Long groupId) {
//		return studentService.getStudentsByGroupId(groupId);
//	}


}
