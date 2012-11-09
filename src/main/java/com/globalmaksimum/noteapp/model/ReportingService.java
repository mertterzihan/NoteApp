package com.globalmaksimum.noteapp.model;

import java.sql.SQLException;

public interface ReportingService {

	public void generateAndSendReport() throws SQLException,
			ClassNotFoundException;
	
}
