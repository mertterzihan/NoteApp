package com.globalmaksimum.noteapp.model.repository;

import org.springframework.transaction.annotation.Transactional;

import com.globalmaksimum.noteapp.model.User;

public class UserBO {

	private UserDAO userDao;

	@Transactional(readOnly=true)
	public User retrieveUser(String user) {
		return userDao.retrieveUser(user);
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
}
