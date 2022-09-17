package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.students.model.Discipline;

import java.util.List;

@Service
public class DisciplineService {
	private final DisciplineRepository disciplineRepository;

	@Autowired
	public DisciplineService(DisciplineRepository disciplineRepository) {
		this.disciplineRepository = disciplineRepository;
	}

	public List<Discipline> getDisciplines() {
		return disciplineRepository.findAll();
	}

	public void addDiscipline(Discipline discipline) {
		boolean exists = disciplineRepository.existsById(discipline.getId());
		if (!exists) {
			disciplineRepository.save(discipline);
		}
	}
}
