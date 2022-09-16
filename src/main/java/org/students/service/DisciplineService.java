package org.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {
	private DisciplineRepository disciplineRepository;

	@Autowired
	public DisciplineService(DisciplineRepository disciplineRepository) {
		this.disciplineRepository = disciplineRepository;
	}


}
