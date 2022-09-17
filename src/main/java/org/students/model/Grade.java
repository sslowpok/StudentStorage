package org.students.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.students.exceptions.IllegalGradeException;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "grade")
public class Grade {
	@Id
	@GeneratedValue
	private Long id;
	private Integer grade;
	private String description;


	private Long studentId;

	public Grade(Integer grade, String description, Long studentId) {
		setGrade(grade);
		this.description = description;
		this.studentId = studentId;
	}

	public void setGrade(Integer grade) {
		if (grade < 2 || grade > 5) {
			throw new IllegalGradeException("Invalid grade");
		}
		this.grade = grade;
	}
}
