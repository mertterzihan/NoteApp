package com.globalmaksimum.noteapp.model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.globalmaksimum.noteapp.model.Note;

public interface NoteBO {

	public List<Note> retrieveNotes();
	
	public void deleteNote(String id);
	
	public void insertNewNode(String note, Date date, String priority) throws SQLException;
	
	public List<Note> retrieveNotesByDate(Date date);
}
