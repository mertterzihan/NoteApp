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
	public List<Note> retrieveNotes(String username) {
		return entityManager
				.createQuery("select n from Note n where n.username=:username",
						Note.class).setParameter("username", username)
				.getResultList();
	}

	@Override
	public void deleteNote(Integer id, String username) {
		entityManager
				.createQuery(
						"delete from Note n where n.id=:id and n.username=:username")
				.setParameter("id", id).setParameter("username", username)
				.executeUpdate();

	}

	@Override
	public void insertNewNode(String note, Date date, String priority, String username) {
		entityManager.persist(new Note(note, date, priority, username));

	}

	@Override
	public List<Note> retrieveNotesByDate(Date date, String username) {
		// temporaltype truncate date instance to only date exclude time
		return entityManager
				.createQuery("select n from Note n where n.date=:date and n.username=:username",
						Note.class)
				.setParameter("date", date, TemporalType.DATE).setParameter("username", username).getResultList();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
