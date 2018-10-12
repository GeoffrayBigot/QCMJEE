package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Test;
import dal.TestDAOJdbcImpl;

public class GestionTest {

	private static TestDAOJdbcImpl testsDAO = new TestDAOJdbcImpl();
	
	public ArrayList<Test> selectAllTest() throws SQLException {
		try {
			return testsDAO.selectAll();	

		} catch (SQLException e) {
			throw new SQLException("probleme GestionTheme fermeture connexion" + e.getMessage());
		}
	}
}
