package org.students.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.students.model.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
