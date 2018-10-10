package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Promotion;
import util.DBConnection;

public class PromotionDAOJdbcImpl {
	
	private static final String selectPromotions = "Select codePromo, libelle from Promotion;";
	
	public static ArrayList<Promotion> selectAll() throws SQLException {
		Promotion unePromo = null;
		ArrayList<Promotion> promos = new ArrayList<>();
		
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			cnx = DBConnection.seConnecter();
			
			stmt = cnx.createStatement();
			rs= stmt.executeQuery(selectPromotions);
			while(rs.next()) {
				unePromo= new Promotion(rs.getString(1),rs.getString(2));
				
				
				promos.add(unePromo);
			}
		}catch (SQLException e) {
			throw new SQLException("probleme PromotionDAO methode lister"+e.getMessage());
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme PromotionDAO fermeture connexion"+e.getMessage());
			}
			
		}
		return promos;
	}
	
}
