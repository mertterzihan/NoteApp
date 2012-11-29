package com.globalmaksimum.noteapp.model.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.repository.NoteDAO;

public class JpaNoteDAO implements NoteDAO {
	private EntityManager entityManager;

	@Override
	public List<Note> retrieveNotes() {
		return entityManager.createQuery("select n from Note n", Note.class)
				.getResultList();
	}

	@Override
	public void deleteNote(Integer id) {
		entityManager.createQuery("delete from Note n where n.id=:id")
				.setParameter("id", id).executeUpdate();

	}

	@Override
	public void insertNewNode(String note, Date date, String priority) {
		entityManager.persist(new Note(note, date, priority));

	}

	@Override
	public List<Note> retrieveNotesByDate(Date date) {
		// temporaltype truncate date instance to only date exclude time
		return entityManager
				.createQuery("select n from Note n where n.date=:date",
						Note.class)
				.setParameter("date", date, TemporalType.DATE).getResultList();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
