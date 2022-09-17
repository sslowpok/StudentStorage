package org.students.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
//@Embeddable
@Table(name = "discipline")
public class Discipline {
	@Id
	@SequenceGenerator(
			name = "discipline_sequence",
			sequenceName = "discipline_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "discipline_sequence"
	)
	private Long id;
	private String name;

	public Discipline(String name) {
		this.name = name;
	}
}


