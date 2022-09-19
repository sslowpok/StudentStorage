package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.students.model.Grade;
import org.students.model.Student;

import javax.transaction.Transactional;
import java.util.List;

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

//	check if exists is unnecessary here
//	what is student passed here?
	@Transactional
	public void addGrade(Grade grade) {
		boolean exists = gradeRepository.existsById(grade.getId());
		if (!exists) {
			gradeRepository.save(grade);
		}
	}

}
