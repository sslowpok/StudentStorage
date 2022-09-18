package org.students.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "academic_group")
public class Group {
	@Id
	@SequenceGenerator(
			name = "group_sequence",
			sequenceName = "group_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "group_sequence"
	)
	private Long id;
	private String name;

	@OneToMany(mappedBy = "group")
	private Set<Student> students;

	public Group(String name) {
		this.name = name;
	}
}
