package org.students.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@ToString
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Group group = (Group) o;
		return Objects.equals(id, group.id) && Objects.equals(name, group.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
