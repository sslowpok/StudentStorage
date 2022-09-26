package org.students.exceptions;

public class DisciplineNotFoundException extends IllegalStateException {
	public DisciplineNotFoundException(String s) {
		super(s);
	}
}
