package org.students.api.dto.student;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {

	@Schema(description = "Student id", example = "1")
	private Long id;

	@Schema(description = "First name", example = "Tom")
	private String firstName;

	@Schema(description = "Last name", example = "Brown")
	private String lastName;

}
