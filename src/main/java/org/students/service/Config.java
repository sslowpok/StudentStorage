package org.students.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.students.model.Discipline;
import org.students.model.Group;
import org.students.model.Student;

@Configuration
public class Config {

	@Bean
	CommandLineRunner commandLineRunner1(StudentRepository studentRepository,
										 GroupRepository groupRepository,
										 DisciplineRepository disciplineRepository) {
		return args -> {

			Group group1 = new Group("Group1");
			Group group2 = new Group("Group2");
			Group group3 = new Group("Group3");



			Student wade = new Student(
					"Wade",
					"Allen",
					25
			);
			Student dave = new Student(
					"Dave",
					"Lopez",
					31

			);
			Student riley = new Student(
					"Riley",
					"Long",
					17
			);

			wade.setGroup(group1);

			groupRepository.save(group1);
			groupRepository.save(group2);
			groupRepository.save(group3);
			studentRepository.save(wade);
			studentRepository.save(dave);
			studentRepository.save(riley);

//			Discipline maths = new Discipline("Maths");
//			Discipline biology = new Discipline("Biology");
//			Discipline chemistry = new Discipline("Chemistry");
//
//			disciplineRepository.save(maths);
//			disciplineRepository.save(biology);
//			disciplineRepository.save(chemistry);

		};
	}

}
