package org.students.exceptions;

public class StudentNotFoundException extends IllegalStateException {
	public StudentNotFoundException(String message) {
		super(message);
	}
}
