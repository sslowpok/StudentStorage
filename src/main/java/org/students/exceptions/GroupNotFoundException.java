package org.students.exceptions;

public class GroupNotFoundException extends RuntimeException{
	public GroupNotFoundException(String message) {
		super(message);
	}
}
