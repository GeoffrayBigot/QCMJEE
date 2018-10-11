package util;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DBConnection {

	private static final String URL="jdbc:sqlserver://127.0.0.1:1433;databaseName=QCMJEE";
	private static final String USER="sa";
	private static final String PWD="Pa$$w0rd";
	
	
	public static Connection seConnecter() throws SQLException {
		Connection cnx= null;
		try {
			DriverManager.registerDriver(new SQLServerDriver());
		} catch (SQLException e) {
			throw new SQLException("Impossible de charger le driver JDBC "+e.getMessage());
		}
		try {
			cnx= DriverManager.getConnection(URL,USER,PWD);
		} catch(SQLException e) {
			throw new SQLException("Impossible d'obtenir la connexion"+e.getMessage());
		}		
		
		
		return cnx;
	}
	
	
}




















