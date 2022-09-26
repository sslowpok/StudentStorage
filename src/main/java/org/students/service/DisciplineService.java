package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.students.exceptions.DisciplineNotFoundException;
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

	public void deleteDisciplineById(Long id) {
		boolean exists = disciplineRepository.existsById(id);
		if (!exists) {
			throw new DisciplineNotFoundException(
					"Discipline with id " + id + " does not exist"
			);
		}
		disciplineRepository.deleteById(id);
	}
}
