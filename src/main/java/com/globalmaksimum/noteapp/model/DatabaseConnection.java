package com.globalmaksimum.noteapp.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class DatabaseConnection {

	private DataSource dataSource;

	
	protected Connection openConnection() throws SQLException {
		return dataSource.getConnection();
	}

	
	public void closeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
