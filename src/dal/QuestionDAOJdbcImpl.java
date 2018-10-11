package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Question;
import bo.Theme;
import util.DBConnection;

public class QuestionDAOJdbcImpl {

	private static final String selectAll = "select idQuestion, enonce, media, points, q.idTheme, t.libelle from Question q"
			+ " join Theme t on t.idTheme = q.idTheme";
	
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
				uneQuestion = new Question(new Theme(rs.getInt(5), rs.getString(6)), rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				questions.add(uneQuestion);
			}
		} catch (SQLException e) {
			throw new SQLException("probleme UtilisateurDAO methode lister" + e.getMessage());
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme UtilisateurDAO fermeture connexion" + e.getMessage());
			}
		}
		return questions;
	}
	
}
