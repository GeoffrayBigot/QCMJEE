package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Promotion;
import util.DBConnection;

public class PromotionDAOJdbcImpl {
	
	private static final String selectPromotions = "Select codePromo, Libelle from Promotion;";
	private static final String insertPromotion = "insert into Promotion(codePromo,Libelle) values(?,?);";

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
	public static void insertPromotion(Promotion vPromotion) throws SQLException{
		Connection cnx = null;
		PreparedStatement  stmt = null;

		try {
			cnx = DBConnection.seConnecter();
			stmt= cnx.prepareStatement(insertPromotion); 
			
			stmt.setString(1, vPromotion.getCodePromotion());

			stmt.setString(2, vPromotion.getLibelle());


			stmt.execute();
			System.out.println("Insertion réalisée avec succès");
			
		}catch (SQLException e) {
			throw new SQLException("probleme PromotionDAO methode insert"+e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme PromotionDAO fermeture connexion"+e.getMessage());
			}
			
		}
	}
}
