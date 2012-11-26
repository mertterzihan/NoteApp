package com.globalmaksimum.noteapp.model.repository.jpa;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.repository.NoteBO;

public class JpaNoteBO implements NoteBO {
	
	private JpaNoteDAO jpaNoteDao;

	@Override
	public List<Note> retrieveNotes() {
		return jpaNoteDao.retrieveNotes();
	}

	@Override
	public void deleteNote(String id) {
		jpaNoteDao.deleteNote(id);

	}

	@Override
	public void insertNewNode(String note, Date date, String priority) throws SQLException {
		jpaNoteDao.insertNewNode(note, date, priority);

	}

	@Override
	public List<Note> retrieveNotesByDate(Date date) {
		return jpaNoteDao.retrieveNotesByDate(date);
	}

	public JpaNoteDAO getJpaNoteDao() {
		return jpaNoteDao;
	}

	public void setJpaNoteDao(JpaNoteDAO jpaNoteDao) {
		this.jpaNoteDao = jpaNoteDao;
	}

}
