package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Profil;
import bo.Promotion;
import bo.Utilisateur;
import util.DBConnection;

public class UtilisateurDAOJdbcImpl {

	private static final String selectUsers = "Select * from Utilisateur;";
	private static final String selectConnection = "Select * from Utilisateur where email =? and password =?";
	

	public static ArrayList<Utilisateur> selectAll() throws SQLException {
		Utilisateur unUtilisateur = null;
		ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DBConnection.seConnecter();	
			stmt = cnx.createStatement();
			rs= stmt.executeQuery(selectUsers);
			//traitement du rs
			while(rs.next()) {
				unUtilisateur= new Utilisateur(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));	
				utilisateurs.add(unUtilisateur);
			}
		}catch (SQLException e) {
			throw new SQLException("probleme UtilisateurDAO methode lister"+e.getMessage());
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme UtilisateurDAO fermeture connexion"+e.getMessage());
			}	
		}
		return utilisateurs;
	}
	
	public static Utilisateur selectconnection(String eMail, String pass) throws SQLException {
		Utilisateur user = null;
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DBConnection.seConnecter();	
			stmt = cnx.prepareStatement(selectConnection);
			stmt.setString(1, eMail);
			stmt.setString(2, pass);
			//traitement du rs
				user = new Utilisateur(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), new Profil("Profil1", "Profil1"),new Promotion("CDI2018", "CDI2018"));	
			} finally {
				stmt.close();
				cnx.close();
			}	
		return user;
	}
	
}
