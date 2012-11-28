package com.globalmaksimum.noteapp.model.repository;

import java.util.Date;
import java.util.List;

import com.globalmaksimum.noteapp.model.Note;

public interface NoteDAO {

	public abstract List<Note> retrieveNotes();
	
	public abstract void deleteNote(Integer id);
	
	public abstract void insertNewNode(String note, Date date, String priority);
	
	public abstract List<Note> retrieveNotesByDate(Date date);
}
