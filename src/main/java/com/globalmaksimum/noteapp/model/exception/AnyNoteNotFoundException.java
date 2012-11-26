package com.globalmaksimum.noteapp.model.exception;


public class AnyNoteNotFoundException extends NoteAppException {

	public AnyNoteNotFoundException() {
		super("No note was found!");
		
	}
}
