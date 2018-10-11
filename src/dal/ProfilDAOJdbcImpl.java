package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Profil;
import util.DBConnection;

public class ProfilDAOJdbcImpl {

	
	private static final String selectProfils = "Select codeProfil, libelle from Profil;";
	private static final String insertProfil = "insert into Profil(codeProfil,libelle) values(?,?);";
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
				unProfil= new Profil(rs.getInt(1),rs.getString(2));
				
				
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
	public static void insertProfil(Profil vProfil) throws SQLException{
		Connection cnx = null;
		PreparedStatement  stmt = null;

		try {
			cnx = DBConnection.seConnecter();
			stmt= cnx.prepareStatement(insertProfil); 
			
			stmt.setInt(1, vProfil.getCodeProfil());

			stmt.setString(2, vProfil.getLibelle());


			stmt.execute();
			System.out.println("Insertion réalisée avec succès");
			
		}catch (SQLException e) {
			throw new SQLException("probleme ProfilDAO methode insert"+e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme ProfilDAO fermeture connexion"+e.getMessage());
			}
			
		}
	}
	
}
