package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Profil;
import bo.Promotion;
import bo.Section;
import bo.Test;
import util.DBConnection;

public class TestDAOJdbcImpl {

	private static final String selectAll = "Select * from Test;";
	private static final String selectById = "Select idTest, libelle,description, duree, seuil_haut, seuil_bas from Test where idTest = ?;";
	public  ArrayList<Test> selectAll() throws SQLException {
		Test unTest = null;
		ArrayList<Test> tests = new ArrayList<>();
		
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			cnx = DBConnection.seConnecter();
			
			stmt = cnx.createStatement();
			rs= stmt.executeQuery(selectAll);
			//traitement du rs
			while(rs.next()) {
				unTest= new Test(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5), rs.getInt(6));
				tests.add(unTest);
			}
		}catch (SQLException e) {
			throw new SQLException("probleme TestDAO methode lister"+e.getMessage());
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme TestDAO fermeture connexion"+e.getMessage());
			}
			
		}
		return tests;
	}
	public static Test selectById(int idTest) throws SQLException {
		Test test = null;
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(selectById);
			stmt.setInt(1, idTest);
			rs = stmt.executeQuery();
			while (rs.next()) {
				test = new Test(idTest, rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6) );
			}
		}catch (SQLException e) {
			throw new SQLException("probleme ProfilDAO fermeture connexion " + e.getMessage());
		} finally {
			stmt.close();
			cnx.close();
		}
		return test;
	}

	
}
