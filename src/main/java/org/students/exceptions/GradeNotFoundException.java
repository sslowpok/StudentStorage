package org.students.exceptions;

public class GradeNotFoundException extends IllegalStateException {
	public GradeNotFoundException(String s) {
		super(s);
	}
}
