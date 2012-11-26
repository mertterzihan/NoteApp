package com.globalmaksimum.noteapp.model.repository;

import com.globalmaksimum.noteapp.model.User;

public interface UserBO {

	public abstract User retrieveUser(String user);
}
