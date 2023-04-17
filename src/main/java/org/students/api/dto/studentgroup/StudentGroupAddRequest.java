package org.students.api.dto.studentgroup;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentGroupAddRequest {

	private String name;

	private List<String> studentList;

}
