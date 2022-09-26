package org.students.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.students.exceptions.GroupNotFoundException;
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
import java.util.stream.IntStream;

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

	@Operation(summary = "Get list of students. Parameters: name, surname, age")
	@GetMapping(path = "students")
	public List<Student> getStudents(
			@RequestParam(required = false) String searchBy,
			@RequestParam(required = false) String searchByParameter,
			@RequestParam(required = false) String sortBy) {
		return studentService.getStudents(searchBy, searchByParameter, sortBy);
	}

	@Operation(summary = "Add new student")
	@PostMapping(path = "students/new")
	public void addStudent(@RequestBody Student student) {
		if (groupService.existsById(student.getGroupId())) {
			studentService.addStudent(student);
		} else {
			throw new GroupNotFoundException(
					"Group with id " + student.getGroupId() + " does not exist"
			);
		}
	}

	@Operation(summary = "Get student by id")
	@GetMapping(path = "students/{id}")
	public Student getStudentById(@PathVariable("id") Long id) {
		return studentService.getStudentById(id);
	}

	@Operation(summary = "Get students by group id")
	@GetMapping(path = "students/group-id/{groupId}")
	public List<Student> getStudentByGroupId(@PathVariable("groupId") Long groupId) {
		return studentService.getStudentsByGroupId(groupId);
	}

	@Operation(summary = "Delete student by id")
	@DeleteMapping(path = "students/{id}")
	public void deleteStudentById(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
	}

	@Operation(summary = "Get list of groups")
	@GetMapping(path = "groups")
	public List<Group> getGroups() {
		return groupService.getGroups();
	}

	@Operation(summary = "Add new group")
	@PostMapping(path = "groups/new")
	public void addGroup(@RequestBody Group group) {
		groupService.addGroup(group);
	}

	@Operation(summary = "Delete group by id")
	@DeleteMapping(path = "groups/{id}")
	public void deleteGroupById(@PathVariable("id") Long id) {
		groupService.deleteGroupById(id);
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

	@Operation(summary = "Delete grade by id")
	@DeleteMapping(path = "grades/{id}")
	public void deleteGradeById(@PathVariable("id") Long id) {
		gradeService.deleteGradeById(id);
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

	@Operation(summary = "Delete discipline by id")
	@DeleteMapping(path = "disciplines/{id}")
	public void deleteDisciplineById(@PathVariable("id") Long id) {
		disciplineService.deleteDisciplineById(id);
	}

	@Operation(summary = "Get grade statistics")
	@GetMapping(path = "grades/statistics")
	public Map<String, Map<String, Double>> getStatistics() {
		Map<String, Map<String, Double>> statMap = new HashMap<>();
		statMap.put("Average for disciplines", statMaker());
		return statMap;
	}

	private Map<String, Double> statMaker() {
		Map<String, Double> disciplineGradeMap = new HashMap<>();

		List<Grade> listOfGrades = new ArrayList<>();
		List<Discipline> listOfDisciplines = disciplineService.getDisciplines();

		listOfDisciplines.forEach(discipline -> {
			listOfGrades.addAll(gradeService.getDisciplineGrades(discipline.getId()));
			int summ = listOfGrades.stream()
					.flatMapToInt(grade -> IntStream.of(grade.getGrade()))
					.reduce(0, Integer::sum);
			double average = listOfGrades.size() == 0 ? 0D : (double)summ / listOfGrades.size();
			disciplineGradeMap.put(discipline.getName(), average);
			listOfGrades.clear();
		});
		return disciplineGradeMap;
	}

}
