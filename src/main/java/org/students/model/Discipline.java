package org.students.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Discipline that = (Discipline) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}


