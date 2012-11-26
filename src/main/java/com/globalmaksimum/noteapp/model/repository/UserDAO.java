package com.globalmaksimum.noteapp.model.repository;

import java.sql.SQLException;

import com.globalmaksimum.noteapp.model.User;

public interface UserDAO {

	public abstract User retrieveUser(String user) throws SQLException;

}