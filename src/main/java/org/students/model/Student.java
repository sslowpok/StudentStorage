package org.students.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Data
@Entity
@Table(name = "student")
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
	)
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Long groupId;

	public Student(String firstName, String lastName, Integer age, Long groupId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.groupId = groupId;
	}

	public Student(Long id, String firstName, String lastName, Integer age, Long groupId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.groupId = groupId;
	}
}
