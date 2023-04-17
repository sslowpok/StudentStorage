package org.students.api.dto.studentgroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.students.model.Student;

import java.util.List;

@Data
@Builder
public class StudentGroupResponse {

	@Schema(description = "Identifier", example = "1")
	private Long id;

	@Schema(description = "Group name", example = "1st group")
	private String name;

	private List<Student> studentList;

}
