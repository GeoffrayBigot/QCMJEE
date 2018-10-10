package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Profil;
import util.DBConnection;

public class ProfilDAOJdbcImpl {

	
	private static final String selectProfils = "Select codeProfil, libelle from Profil;";
	
	public static ArrayList<Profil> selectAll() throws SQLException {
		Profil unProfil = null;
		ArrayList<Profil> profils = new ArrayList<>();
		
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			cnx =  DBConnection.seConnecter();
			
			stmt = cnx.createStatement();
			rs= stmt.executeQuery(selectProfils);
			while(rs.next()) {
				unProfil= new Profil(rs.getString(1),rs.getString(2));
				
				
				profils.add(unProfil);
			}
		}catch (SQLException e) {
			throw new SQLException("probleme ProfilDAO methode lister"+e.getMessage());
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme ProfilDAO fermeture connexion"+e.getMessage());
			}
			
		}
		return profils;
	}		
}
