package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Section;
import bo.Test;
import dal.SectionDAOJdbcImpl;
import dal.TestDAOJdbcImpl;

public class GestionTest {

	private static TestDAOJdbcImpl testsDAO = new TestDAOJdbcImpl();
	private static SectionDAOJdbcImpl sectionsDAO = new SectionDAOJdbcImpl();
	public ArrayList<Test> selectAllTest() throws SQLException {
		try {
			return testsDAO.selectAll();	

		} catch (SQLException e) {
			throw new SQLException("probleme GestionTheme fermeture connexion" + e.getMessage());
		}
	}
	public ArrayList<Section> selectSectionsByIdTest(int idTest){
		try {
			return sectionsDAO.selectSelonTest(idTest);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
