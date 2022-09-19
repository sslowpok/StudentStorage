package org.students.model;

import io.swagger.v3.oas.annotations.Hidden;
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
	@GeneratedValue
	private Long id;
	private Integer grade;
	private String description;


//	private Long studentId;

	public Grade(Integer grade, String description) {
		setGrade(grade);
		this.description = description;
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
		return Objects.equals(id, grade1.id) && Objects.equals(grade, grade1.grade) && Objects.equals(description, grade1.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, grade, description);
	}
}
