package dal;

import java.sql.Connection;
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
	public static ArrayList<Utilisateur> select() throws SQLException {
		Utilisateur unUtilisateur = null;
		ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
		
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			cnx = DBConnection.seConnecter();
			
			stmt = cnx.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_READ_ONLY);
			rs= stmt.executeQuery(selectUsers);
			//traitement du rs
			while(rs.next()) {
				unUtilisateur= new Utilisateur(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), new Profil("Profil1", "Profil1"),new Promotion("CDI2018", "CDI2018"));
				
				
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
	
}
