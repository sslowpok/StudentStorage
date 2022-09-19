package org.students.model;

import lombok.*;
import org.students.exceptions.IllegalGradeException;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "grade")
public class Grade {
	@Id
	@SequenceGenerator(
			name = "grade_sequence",
			sequenceName = "grade_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "grade_sequence"
	)
	private Long id;
	private Integer grade;
	private String description;
	private Long studentId;
	private Long disciplineId;

	public Grade(Integer grade, String description) {
		setGrade(grade);
		this.description = description;
	}

	public Grade(Integer grade, String description, Long studentId, Long disciplineId) {
		this.grade = grade;
		this.description = description;
		this.studentId = studentId;
		this.disciplineId = disciplineId;
	}

	public void setGrade(Integer grade) {
		if (grade < 2 || grade > 5) {
			throw new IllegalGradeException("Invalid grade");
		}
		this.grade = grade;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Grade grade1 = (Grade) o;
		return Objects.equals(id, grade1.id) && Objects.equals(grade, grade1.grade) && Objects.equals(description, grade1.description) && Objects.equals(studentId, grade1.studentId) && Objects.equals(disciplineId, grade1.disciplineId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, grade, description, studentId, disciplineId);
	}
}
