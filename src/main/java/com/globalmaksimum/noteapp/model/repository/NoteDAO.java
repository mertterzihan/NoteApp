package com.globalmaksimum.noteapp.model.repository;

import java.util.Date;
import java.util.List;

import com.globalmaksimum.noteapp.model.Note;

public interface NoteDAO {

	public abstract List<Note> retrieveNotes(String username);
	
	public abstract void deleteNote(Integer id, String username);
	
	public abstract void insertNewNode(String note, Date date, String priority, String username);
	
	public abstract List<Note> retrieveNotesByDate(Date date, String username);
}
