package com.globalmaksimum.noteapp.model;

import java.sql.SQLException;

public interface UserRepository {

	public abstract User retrieveUser(String user) throws SQLException;

}