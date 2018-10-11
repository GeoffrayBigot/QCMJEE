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
	public static ArrayList<Test> selectAll() throws SQLException {
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
	

	
}
