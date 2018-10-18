package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Epreuve;
import bo.QuestionEpreuve;
import bo.Section;
import dal.EpreuveDAOJdbcImpl;
import dal.QuestionEpreuveDAOJdbcImpl;
import dal.SectionDAOJdbcImpl;

public class GestionEpreuve {

	private static EpreuveDAOJdbcImpl epreuvesDAO = new EpreuveDAOJdbcImpl();
	private static SectionDAOJdbcImpl sectionDAO = new SectionDAOJdbcImpl();
	private static QuestionEpreuveDAOJdbcImpl questionsEpreuvesDAO = new QuestionEpreuveDAOJdbcImpl();
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
	public ArrayList<QuestionEpreuve> selectQuestionsEpreuvesSelonIdEpreuve(int idEpreuve)  throws SQLException {
		try {
			return questionsEpreuvesDAO.selectByIdEpreuve(idEpreuve);
		} catch (SQLException e) {
			throw new SQLException("probleme GestionEpreuve methode select questions by epreuve" + e.getMessage());
		}
	}
	

}
