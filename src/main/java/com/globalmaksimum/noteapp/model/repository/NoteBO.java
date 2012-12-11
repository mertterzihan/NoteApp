package com.globalmaksimum.noteapp.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.globalmaksimum.noteapp.model.Note;

public class NoteBO {
	
	private NoteDAO noteDao;

	@Transactional(readOnly=true)
	public List<Note> retrieveNotes(String username) {
		return noteDao.retrieveNotes(username);
	}

	@Transactional(rollbackFor=DataAccessException.class)
	public void deleteNote(Integer id, String username) {
		noteDao.deleteNote(id, username);

	}

	@Transactional(rollbackFor=DataAccessException.class)
	public void insertNewNode(String note, Date date, String priority, String username){
		noteDao.insertNewNode(note, date, priority, username);

	}

	@Transactional(readOnly=true)
	public List<Note> retrieveNotesByDate(Date date, String username) {
		return noteDao.retrieveNotesByDate(date, username);
	}

	public NoteDAO getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDAO noteDao) {
		this.noteDao = noteDao;
	}
}
