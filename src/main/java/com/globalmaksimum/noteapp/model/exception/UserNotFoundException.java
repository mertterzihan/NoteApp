package com.globalmaksimum.noteapp.model.exception;


public class UserNotFoundException extends NoteAppException {

	public UserNotFoundException(String username) {
		super("User not found for: " + username);
		
	}

}
