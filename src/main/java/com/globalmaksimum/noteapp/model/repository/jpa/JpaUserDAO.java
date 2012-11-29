package com.globalmaksimum.noteapp.model.repository.jpa;

import javax.persistence.EntityManager;

import com.globalmaksimum.noteapp.model.User;
import com.globalmaksimum.noteapp.model.repository.UserDAO;

public class JpaUserDAO implements UserDAO {

	private EntityManager entityManager;

	@Override
	public User retrieveUser(String user) {
		return entityManager.find(User.class, user);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
