package bll;

import java.sql.SQLException;

import bo.Utilisateur;
import dal.UtilisateurDAOJdbcImpl;

public class GestionConnexion {

	private static UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
	
	public static Utilisateur connexion(String eMail, String pass) throws SQLException {
		Utilisateur user = null ;
		if(eMail != null && pass!=null) {
			if(!eMail.isEmpty() && !pass.isEmpty()) {
			 user = utilisateurDAO.selectConnection(eMail, pass);
			}
		}
		if(user == null) {
			return null;			
		} else {
			return user;			
		}
	}

}
