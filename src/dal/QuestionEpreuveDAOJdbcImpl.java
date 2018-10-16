package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.QuestionEpreuve;
import bo.ReponseEpreuve;
import util.DBConnection;

public class QuestionEpreuveDAOJdbcImpl {

	
	private static final String insertQuestionEpreuve = "insert into Question_tirage(estMarquee, idQuestion,numordre, idEpreuve) values (?,?,?,?)";
	private static final String insertReponseEpreuve = "insert into Reponse_tirage(idProposition, idQuestion, idEpreuve) values (?,?,?)";

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
			System.out.println("question_Epreuve ajoutée avec succès");		
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
			System.out.println("Insertion ReponseEpreuve Succès !");
			
		} catch (SQLException e) {
			throw new SQLException("probleme QuestionEpreuve fermeture connexion " + e.getMessage());
		}
		
	}
	
	
}
