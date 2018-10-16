package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Epreuve;
import bo.Section;
import dal.EpreuveDAOJdbcImpl;
import dal.SectionDAOJdbcImpl;

public class GestionEpreuve {

	private static EpreuveDAOJdbcImpl epreuvesDAO = new EpreuveDAOJdbcImpl();
	private static SectionDAOJdbcImpl sectionDAO = new SectionDAOJdbcImpl();

	public Epreuve selectById(int idEpreuve) throws SQLException {
		try {
			return epreuvesDAO.selectbyId(idEpreuve);

		} catch (SQLException e) {
			throw new SQLException("probleme GestionEpreuve fermeture connexion" + e.getMessage());
		}
	}

	public ArrayList<Epreuve> selectEpreuvesByIdUtilisateur(int idUtilisateur) throws SQLException {
		try {
			return epreuvesDAO.selectbyIdUtilisateur(idUtilisateur);
		} catch (SQLException e) {
			throw new SQLException("probleme GestionEpreuve fermeture connexion" + e.getMessage());
		}
	}

	public ArrayList<Section> selectSelonTest(int idTest) throws SQLException {
		try {
			return sectionDAO.selectSelonTest(idTest);
		} catch (SQLException e) {
			throw new SQLException("probleme GestionEpreuve fermeture connexion" + e.getMessage());
		}
	}
	

}
