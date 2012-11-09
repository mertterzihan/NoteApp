package com.globalmaksimum.noteapp.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface NoteRepository {

	public abstract List<Note> retrieveNotes() throws SQLException;
	
	public abstract void deleteNote(String id) throws SQLException;
	
	public abstract void insertNewNode(String note, Date date, String priority)
			throws SQLException;
	
	public abstract List<Note> retrieveNotesByDate(Date date) throws SQLException;
}
