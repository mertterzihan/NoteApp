package com.globalmaksimum.noteapp.model;

public class AnyNoteNotFoundException extends NoteAppException {

	public AnyNoteNotFoundException() {
		super("No note was found!");
		
	}
}
