package com.globalmaksimum.noteapp.model.repository.jpa;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.globalmaksimum.noteapp.model.User;
import com.globalmaksimum.noteapp.model.repository.UserDAO;

public class JpaUserDAO extends HibernateDaoSupport implements UserDAO {
	
	JpaUserDAO() {
		super();

	}

	@Override
	public User retrieveUser(String user) {
		List list = getHibernateTemplate().find("from User where username=?", user);
		return (User)list.get(0);
	}


}
