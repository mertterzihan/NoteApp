package com.globalmaksimum.noteapp.model.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.repository.NoteDAO;

public class JpaNoteDAO implements NoteDAO {
	private EntityManager entityManager;

	@Override
	public List<Note> retrieveNotes() {
		Subject subject = SecurityUtils.getSubject();
		return entityManager
				.createQuery("select n from Note n where n.username=:username",
						Note.class)
				.setParameter("username", subject.getPrincipal().toString())
				.getResultList();
	}

	@Override
	public void deleteNote(Integer id) {
		Subject subject = SecurityUtils.getSubject();
		entityManager.createQuery("delete from Note n where n.id=:id and n.username=:username")
				.setParameter("id", id).setParameter("username", subject.getPrincipal().toString()).executeUpdate();

	}

	@Override
	public void insertNewNode(String note, Date date, String priority) {
		Subject subject = SecurityUtils.getSubject();
		entityManager.persist(new Note(note, date, priority, subject
				.getPrincipal().toString()));

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
