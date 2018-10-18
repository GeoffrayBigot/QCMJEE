package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Question;
import bo.QuestionEpreuve;
import bo.ReponseEpreuve;
import bo.Theme;
import util.DBConnection;

public class QuestionEpreuveDAOJdbcImpl {

	
	private static final String insertQuestionEpreuve = "insert into Question_tirage(estMarquee, idQuestion,numordre, idEpreuve) values (?,?,?,?)";
	private static final String insertReponseEpreuve = "insert into Reponse_tirage(idProposition, idQuestion, idEpreuve) values (?,?,?)";
	private static final String selectByIdEpreuve = "select qt.estMarquee, qt.idQuestion, qt.numordre, qt.idEpreuve, q.points, q.idTheme, q.enonce, q.media from Question_tirage qt join Question q on q.idQuestion = qt.idQuestion  where qt.idEpreuve=?;";
	public void insertQuestionEpreuve(QuestionEpreuve vQuestionEpreuve, int idEpreuve,int ordre, ArrayList<ReponseEpreuve> reponses_epreuves) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DBConnection.seConnecter();
			
			stmt = cnx.prepareStatement(insertQuestionEpreuve,Statement.RETURN_GENERATED_KEYS);
			stmt.setBoolean(1, false);
			stmt.setInt(2, vQuestionEpreuve.getIdQuestion());
			stmt.setInt(3, ordre);
			stmt.setInt(4,idEpreuve);
			int ligne =stmt.executeUpdate();
			System.out.println("question_Epreuve ajout�e avec succ�s");		
			if(ligne == 1 ) {
				rs = stmt.getGeneratedKeys();		
				if(rs.next()) {
					insertReponseEpreuve(reponses_epreuves,vQuestionEpreuve.getIdQuestion());
				}
			}
			
		} catch (SQLException e) {
			throw new SQLException("probleme QuestionEpreuveDAO fermeture connexion " + e.getMessage());
		}
		
	}

	private static void insertReponseEpreuve(ArrayList<ReponseEpreuve> reponses_epreuve, int idQuestion) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
				for (ReponseEpreuve p : reponses_epreuve) {
					if(p.getIdQuestion()==idQuestion){
						stmt = cnx.prepareStatement(insertReponseEpreuve);
						stmt.setInt(1, p.getIdReponse());
						stmt.setInt(2, p.getIdQuestion());
						stmt.setInt(3, p.getIdEpreuve());
						stmt.execute();
					}
				}			
			System.out.println("Insertion ReponseEpreuve Succ�s !");
			
		} catch (SQLException e) {
			throw new SQLException("probleme QuestionEpreuve fermeture connexion " + e.getMessage());
		}
	}
	public ArrayList<QuestionEpreuve> selectByIdEpreuve(int idEpreuve) throws SQLException {
		QuestionEpreuve uneQuestionEpreuve = null;
		ArrayList<QuestionEpreuve> questionsEpreuves = new ArrayList<>();
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(selectByIdEpreuve);
			stmt.setInt(1, idEpreuve);
			rs = stmt.executeQuery();
			while (rs.next()) {
				uneQuestionEpreuve = new QuestionEpreuve(rs.getInt(2), rs.getInt(6), rs.getString(7), rs.getBytes(8), rs.getInt(5));
				questionsEpreuves.add(uneQuestionEpreuve);
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
		return questionsEpreuves;
	}
	
}
