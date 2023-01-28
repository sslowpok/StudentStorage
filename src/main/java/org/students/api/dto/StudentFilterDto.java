package org.students.api.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Parameters for filter")
public class StudentFilterDto {

    @Parameter(description = "Search field")
    private String search;

    @Parameter(description = "Sort field")
    private String sort;

}
