package org.students.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student_group")
@Where(clause = "deleted=false")
public class StudentGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@JsonManagedReference
	@OneToMany(orphanRemoval = true, mappedBy = "group", fetch = FetchType.LAZY)
	private List<Student> studentList;

}
