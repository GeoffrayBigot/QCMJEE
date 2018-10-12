package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Proposition;
import bo.Question;
import dal.PropositionDAOjdbcImpl;
import dal.QuestionDAOJdbcImpl;

public class GestionQuestions {
	
	private static QuestionDAOJdbcImpl questionsDAO = new QuestionDAOJdbcImpl();
	private static PropositionDAOjdbcImpl propositionDAO = new PropositionDAOjdbcImpl();
	
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
	public ArrayList<Question> selectQuestionsByIdTheme(int idTheme) throws SQLException {
		try {
			return questionsDAO.selectQuestionByIdTheme(idTheme);	
		} catch (SQLException e) {
			throw new SQLException("probleme GestionQuestion fermeture connexion" + e.getMessage());
		}
	}
}
