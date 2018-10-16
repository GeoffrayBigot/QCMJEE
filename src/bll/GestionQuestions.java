package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Proposition;
import bo.Question;
import bo.QuestionEpreuve;
import bo.ReponseEpreuve;
import bo.Theme;
import dal.PropositionDAOjdbcImpl;
import dal.QuestionDAOJdbcImpl;
import dal.QuestionEpreuveDAOJdbcImpl;
import dal.ThemeDAOJdbcImpl;

public class GestionQuestions {
	
	private static QuestionDAOJdbcImpl questionsDAO = new QuestionDAOJdbcImpl();
	private static QuestionEpreuveDAOJdbcImpl questionEpreuveDAO = new QuestionEpreuveDAOJdbcImpl();
	private static PropositionDAOjdbcImpl propositionDAO = new PropositionDAOjdbcImpl();
	private static ThemeDAOJdbcImpl themeDAO = new ThemeDAOJdbcImpl();
	
	public ArrayList<Question> selectAllQuestion() throws SQLException {
		try {
			return questionsDAO.selectAll();	
		} catch (SQLException e) {
			throw new SQLException("probleme GestionQuestion fermeture connexion" + e.getMessage());
		}
	}

	public ArrayList<Proposition> selectPropositionByIdQuestion(int idQuestion) throws SQLException {
		try {
			return propositionDAO.selectByIdQuestion(idQuestion);	
		} catch (SQLException e) {
			throw new SQLException("probleme GestionQuestion fermeture connexion" + e.getMessage());
		}
	}
	
	public ArrayList<Proposition> selectAllReponse() throws SQLException {
		try {
			return propositionDAO.selectAllReponse();	
		} catch (SQLException e) {
			throw new SQLException("probleme GestionQuestion fermeture connexion" + e.getMessage());
		}
	}
	
	public void ajouterQuestion(String enonceQ,byte[] img,int pts,int idTheme,ArrayList<Proposition> propositions) throws SQLException {
		try {
			questionsDAO.insertQuestion(new Question(idTheme, enonceQ, img, pts), propositions);
		} catch (SQLException e) {
			throw new SQLException("probleme GestionQuestion fermeture connexion " + e.getMessage());
		}
	}
	
	public void ajouterQuestionEpreuve(QuestionEpreuve vQuestionEpreuve, int idEpreuve,int ordre, ArrayList<ReponseEpreuve> reponses_epreuves) throws SQLException {
		try {
			questionEpreuveDAO.insertQuestionEpreuve(vQuestionEpreuve, idEpreuve, ordre, reponses_epreuves);
		} catch (SQLException e) {
			throw new SQLException("probleme GestionQuestion fermeture connexion " + e.getMessage());
		}
	}
	
	
	public ArrayList<Question> selectQuestionsByIdTheme(int idTheme) throws SQLException {
		try {
			return questionsDAO.selectQuestionByIdTheme(idTheme);	
		} catch (SQLException e) {
			throw new SQLException("probleme GestionQuestion fermeture connexion" + e.getMessage());
		}
	}
	
	public ArrayList<Theme> selectAllTheme() throws SQLException {
		try {
			return themeDAO.selectAll();
		} catch (SQLException e) {			
			throw new SQLException("probleme Theme fermeture connexion" + e.getMessage());
		}
	}
	
}
