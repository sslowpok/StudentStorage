package org.students.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
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

	public Group(String name) {
		this.name = name;
	}
}
