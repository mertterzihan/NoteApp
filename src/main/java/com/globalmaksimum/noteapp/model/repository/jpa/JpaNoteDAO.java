package com.globalmaksimum.noteapp.model.repository.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.User;
import com.globalmaksimum.noteapp.model.repository.NoteDAO;

public class JpaNoteDAO extends HibernateDaoSupport implements
		NoteDAO {

	@Override
	public List<Note> retrieveNotes() {
		return getHibernateTemplate().find("from Note");
	}

	@Override
	public void deleteNote(String id) {
		List list = getHibernateTemplate().find(
                "from Note where id=?",id
          );
		Note note = (Note)list.get(0);
		getHibernateTemplate().delete(note);

	}

	@Override
	public void insertNewNode(String note, Date date, String priority) {
		getHibernateTemplate().save(new Note(note, new java.sql.Date(date.getTime()), priority));

	}

	@Override
	public List<Note> retrieveNotesByDate(Date date) {
		return getHibernateTemplate().find("from Note where date=?", date);
	}

}
