package com.globalmaksimum.noteapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUserRepository extends DatabaseConnection implements UserRepository {

	JDBCUserRepository() throws SQLException, ClassNotFoundException {
		super();

	}

	/* (non-Javadoc)
	 * @see com.globalmaksimum.noteapp.model.UserRepository#retrieveUser(java.lang.String)
	 */
	@Override
	public User retrieveUser(String user) throws SQLException {
		Connection con = null;
		try {
			con = openConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from users where USERNAME = ?");
			preparedStatement.setString(1, user);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return new User(rs.getString("USERNAME"), rs.getString("NAME"),
						rs.getString("SURNAME"), rs.getString("EMAIL"));
			}
			throw new UserNotFoundException(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
	}

}
