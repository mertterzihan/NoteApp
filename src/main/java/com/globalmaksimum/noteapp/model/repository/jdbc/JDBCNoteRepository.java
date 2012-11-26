package com.globalmaksimum.noteapp.model.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.exception.AnyNoteNotFoundException;
import com.globalmaksimum.noteapp.model.repository.NoteDAO;

public class JDBCNoteRepository extends DatabaseConnection implements
		NoteDAO {

	@Override
	public List<Note> retrieveNotes() throws SQLException {
		Connection con = null;
		List<Note> notes = new ArrayList();
		try {
			con = openConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from  DENEME.notes");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				//Date date = new Date(rs.getDate("DATE").getTime());
				notes.add(new Note(new Integer(rs.getInt("id")), rs
						.getString("NOTE"), rs.getDate("DATE"), rs.getString("PRIORITY")));
			}
			if (!notes.isEmpty()) {
				return notes;
			}
			throw new AnyNoteNotFoundException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
	}

	@Override
	public void deleteNote(String id) throws SQLException {
		Connection con = null;
		try {
			con = openConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("delete from notes where id = ?");
			int Id = new Integer(id);
			preparedStatement.setInt(1, Id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}

	}

	@Override
	public void insertNewNode(String note, Date date, String priority)
			throws SQLException {
		Connection con = null;
		try {
			con = openConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into notes values (default, ?, ?, ?)");
			preparedStatement.setString(1, note);
			preparedStatement.setDate(2, new java.sql.Date(date.getTime()));
			preparedStatement.setString(3, priority);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}

	}

	@Override
	public List<Note> retrieveNotesByDate(Date date) throws SQLException {
		Connection con = null;
		List<Note> notes = new ArrayList();
		try {
			con = openConnection();
			PreparedStatement preparedStatement = con.prepareStatement("select * from notes where DATE = ?");
			preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				//Date date2 = new Date(rs.getDate("DATE").getTime());
				notes.add(new Note(new Integer(rs.getInt("id")), rs
						.getString("NOTE"), rs.getDate("DATE"), rs.getString("PRIORITY")));
			}
			if (!notes.isEmpty()) {
				return notes;
			}
			throw new AnyNoteNotFoundException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
	}

}
