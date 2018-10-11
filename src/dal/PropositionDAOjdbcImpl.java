package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Proposition;
import util.DBConnection;

public class PropositionDAOjdbcImpl {

	private static final String selectByIdQuestion = "Select idProposition, enonce, estBonne from Proposition where idQuestion =?;";
	
	public ArrayList<Proposition> selectByIdQuestion(int idQuestion) throws SQLException {
		ArrayList<Proposition> propositions = new ArrayList<>();
		Proposition uneProposition = null;
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(selectByIdQuestion);
			stmt.setInt(1, idQuestion);
			rs = stmt.executeQuery();
			while(rs.next()) {
				uneProposition = new Proposition(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
				propositions.add(uneProposition);
			}
		} catch (SQLException e) {
			throw new SQLException("probleme PropositionDAO methode lister" + e.getMessage());
		}
		return propositions;
	}
}
