package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Proposition;
import bo.Question;
import bo.Theme;
import util.DBConnection;

public class QuestionDAOJdbcImpl {

	private static final String selectAll = "select idQuestion, enonce, media, points, q.idTheme, t.libelle from Question q"
			+ " join Theme t on t.idTheme = q.idTheme";
	private static final String insertQuestion = "insert into Question values (?,?,?,?)";
	private static final String insertProposition = "insert into Proposition(enonce,estBonne,idQuestion) values (?,?,?)";
	
	public ArrayList<Question> selectAll() throws SQLException {
		Question uneQuestion = null;
		ArrayList<Question> questions = new ArrayList<>();
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(selectAll);
			while (rs.next()) {
				uneQuestion = new Question(new Theme(rs.getInt(5), rs.getString(6)), rs.getInt(1), rs.getString(2), rs.getBytes(3), rs.getInt(4));
				questions.add(uneQuestion);
			}
		} catch (SQLException e) {
			throw new SQLException("probleme QuestionDAO methode lister" + e.getMessage());
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme QuestionDAO fermeture connexion" + e.getMessage());
			}
		}
		return questions;
	}
	
	public void insertQuestion(Question question,ArrayList<Proposition> propositions) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DBConnection.seConnecter();
			
			stmt = cnx.prepareStatement(insertQuestion,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, question.getEnonce());
			stmt.setBytes(2, question.getImage());
			stmt.setInt(3, question.getPoint());
			stmt.setInt(4, question.getTheme().getIdTheme());
			int ligne =stmt.executeUpdate();
			System.out.println("question ajouté avec succès");		
			if(ligne == 1 ) {
				rs = stmt.getGeneratedKeys();		
				if(rs.next()) {
					insertProposition(propositions,rs.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			throw new SQLException("probleme QuestionDAO fermeture connexion " + e.getMessage());
		}
		
	}
	
	private static void insertProposition(ArrayList<Proposition> propositions,int idQuestion) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
				for (Proposition p : propositions) {
					stmt = cnx.prepareStatement(insertProposition);
					stmt.setString(1, p.getLibelle());
					stmt.setBoolean(2, p.isEstCorrecte());
					stmt.setInt(3, idQuestion);
					stmt.execute();
				}			
			System.out.println("Insertion Proposition Succès !");
			
		} catch (SQLException e) {
			throw new SQLException("probleme QuestionDAO fermeture connexion " + e.getMessage());
		}
		
	}
	
}
