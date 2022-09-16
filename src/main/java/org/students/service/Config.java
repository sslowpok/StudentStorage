package org.students.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.students.model.Discipline;
import org.students.model.Group;
import org.students.model.Student;

import java.util.List;

@Configuration
public class Config {

	@Bean
	CommandLineRunner commandLineRunner1(StudentRepository studentRepository) {
		return args -> {
			Student wade = new Student(
					"Wade",
					"Allen",
					25,
					1L
			);
			Student dave = new Student(
					"Dave",
					"Lopez",
					31,
					2L
			);
			Student riley = new Student(
					"Riley",
					"Long",
					17,
					2L
			);
			studentRepository.save(wade);
			studentRepository.save(dave);
			studentRepository.save(riley);
		};
	}

	@Bean
	CommandLineRunner commandLineRunner2(GroupRepository groupRepository) {
		return args -> {
			Group group1 = new Group("Group1");
			Group group2 = new Group("Group2");
			Group group3 = new Group("Group3");
			groupRepository.save(group1);
			groupRepository.save(group2);
			groupRepository.save(group3);
		};
	}

	@Bean
	CommandLineRunner commandLineRunner3(DisciplineRepository disciplineRepository) {
		return args -> {
			disciplineRepository.saveAll(List.of(
					new Discipline("Maths"),
					new Discipline("Physics"),
					new Discipline("Chemistry"),
					new Discipline("Biology"),
					new Discipline("Computer Science")));
		};
	}
}
