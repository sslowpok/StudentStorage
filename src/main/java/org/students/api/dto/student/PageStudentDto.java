package org.students.api.dto.student;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.students.model.Student;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Pagination for students list")
public class PageStudentDto {

    @Schema(description = "Number of pages", example = "10")
    private Integer totalPages;

    @Schema(description = "List of students")
    private List<Student> content;

}
