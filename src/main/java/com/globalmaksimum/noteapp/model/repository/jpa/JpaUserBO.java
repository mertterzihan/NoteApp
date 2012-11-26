package com.globalmaksimum.noteapp.model.repository.jpa;

import com.globalmaksimum.noteapp.model.User;
import com.globalmaksimum.noteapp.model.repository.UserBO;

public class JpaUserBO implements UserBO {
	
	private JpaUserDAO jpaUserDAO;

	@Override
	public User retrieveUser(String user) {
		return jpaUserDAO.retrieveUser(user);
	}

	public JpaUserDAO getJpaUserDAO() {
		return jpaUserDAO;
	}

	public void setJpaUserDAO(JpaUserDAO jpaUserDAO) {
		this.jpaUserDAO = jpaUserDAO;
	}

}
