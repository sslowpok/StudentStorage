package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.students.model.Grade;
import org.students.model.Student;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GradeService {
	private final GradeRepository gradeRepository;

	@Autowired
	public GradeService(GradeRepository gradeRepository) {
		this.gradeRepository = gradeRepository;
	}

	public List<Grade> getGrades() {
		return gradeRepository.findAll();
	}

	public void addGrade(Grade grade) {
		boolean exists = gradeRepository.existsById(grade.getId());
		if (!exists) {
			gradeRepository.save(grade);
		}
	}

	public Map<String, Double> getStatistics() {
		Map<String, Double> map = new HashMap<>();

		Map<Long, Double> averageDiscipline = new HashMap<>();



//		map.put("Average Disciplines: ")

		return map;
	}

	public List<Grade> getDisciplineGrades(Long disciplineId) {
		return gradeRepository.findAllByDisciplineId(disciplineId);
	}
}
