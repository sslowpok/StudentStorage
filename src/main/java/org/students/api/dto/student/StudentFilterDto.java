package org.students.api.dto.student;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Parameters for filter")
public class StudentFilterDto {

    @NotNull
    @Parameter(description = "Page number", example = "0")
    private Integer page;

    @NotNull
    @Parameter(description = "Page size", example = "15")
    private Integer size;

    @Parameter(description = "Search field")
    private String search;

    @Parameter(description = "Exact search match", example = "true")
    private boolean exact;

    @Parameter(description = "Sort field")
    private String sort;

}
