package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Section;
import bo.Theme;
import util.DBConnection;

public class SectionDAOJdbcImpl {
	private static final String selectSelonTest = "Select t.libelle,s.nbQuestionsATirer,s.idTest, s.idTheme  from Section_Test s"
			+ " join Theme t on t.idTheme = s.idTheme"
			+ " where s.idTest = ?;";
	public static ArrayList<Section> selectSelonTest(int idTest) throws SQLException {
		ArrayList<Section> sections = new ArrayList<>();
		
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			cnx = DBConnection.seConnecter();
			PreparedStatement prep1 = cnx.prepareStatement(selectSelonTest); 
			prep1.setInt(1, idTest);
			rs= prep1.executeQuery();
			//traitement du rs
			while(rs.next()) {
				sections.add(new Section(rs.getInt(2),new Theme(rs.getInt(4),rs.getString(1))));
			}
		}catch (SQLException e) {
			throw new SQLException("probleme SectionDAO methode lister"+e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme SectionDAO fermeture connexion"+e.getMessage());
			}
			
		}
		return sections;
	}
}
