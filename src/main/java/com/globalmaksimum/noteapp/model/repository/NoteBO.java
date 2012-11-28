package com.globalmaksimum.noteapp.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.globalmaksimum.noteapp.model.Note;

public class NoteBO {
	
	private NoteDAO noteDao;

	@Transactional(readOnly=true)
	public List<Note> retrieveNotes() {
		return noteDao.retrieveNotes();
	}

	@Transactional(rollbackFor=DataAccessException.class)
	public void deleteNote(Integer id) {
		noteDao.deleteNote(id);

	}

	@Transactional(rollbackFor=DataAccessException.class)
	public void insertNewNode(String note, Date date, String priority){
		noteDao.insertNewNode(note, date, priority);

	}

	@Transactional(readOnly=true)
	public List<Note> retrieveNotesByDate(Date date) {
		return noteDao.retrieveNotesByDate(date);
	}

	public NoteDAO getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDAO noteDao) {
		this.noteDao = noteDao;
	}
}
