package org.students.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.students.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
