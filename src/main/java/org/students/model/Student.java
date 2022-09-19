package org.students.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
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

	public Student(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Student(Long id, String firstName, String lastName, Integer age, Long groupId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.groupId = groupId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName)
				&& Objects.equals(lastName, student.lastName) && Objects.equals(age, student.age)
				&& Objects.equals(groupId, student.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, age, groupId);
	}
}
