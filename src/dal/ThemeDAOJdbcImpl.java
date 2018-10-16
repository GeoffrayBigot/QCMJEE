package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Theme;
import util.DBConnection;

public class ThemeDAOJdbcImpl {
	private static final String selectById = "Select * from Theme t where t.idTheme = ?;";
	private static final String selectAll = "Select * from Theme t";
	
	public static Theme selectbyId(int idTheme) throws SQLException {
		Theme vTheme = null;
		Connection cnx = null;
		ResultSet rs = null;
	
		try {
			cnx = DBConnection.seConnecter();
			PreparedStatement prep1 = cnx.prepareStatement(selectById); 
			prep1.setInt(1, idTheme);
			rs= prep1.executeQuery();
			//traitement du rs
			while(rs.next()){
			 vTheme= new Theme(idTheme, rs.getString(2));
			}
		}catch (SQLException e) {
			throw new SQLException("probleme ThemeDAO methode selectById "+e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme ThemeDAO fermeture connexion"+e.getMessage());
			}
		}
		return vTheme;
	}
	
	public ArrayList<Theme> selectAll() throws SQLException {
		ArrayList<Theme> themes = new ArrayList<>();
		Connection cnx = null;
		ResultSet rs = null;
	
		try {
			cnx = DBConnection.seConnecter();
			Statement prep1 = cnx.createStatement(); 
			rs= prep1.executeQuery(selectAll);
			//traitement du rs
			while(rs.next()){
			 themes.add(new Theme(rs.getInt(1), rs.getString(2)));
			}
		}catch (SQLException e) {
			throw new SQLException("probleme ThemeDAO methode selectById "+e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme ThemeDAO fermeture connexion"+e.getMessage());
			}
		}
		return themes;
	}
}
