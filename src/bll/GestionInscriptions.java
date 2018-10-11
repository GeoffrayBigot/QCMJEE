package bll;

import java.sql.SQLException;

import bo.Utilisateur;
import dal.UtilisateurDAOJdbcImpl;

public class GestionInscriptions {

	private static UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
	
	public void inscriptionUser(String nom,String prenom,String email,String password, int codeProfil,String codePromo) throws SQLException {
		try {
			utilisateurDAO.insertUtilisateur(new Utilisateur(nom, prenom, email, password, codeProfil, codePromo));
		} catch (SQLException e) {
			throw new SQLException("probleme GestionInscription fermeture connexion" + e.getMessage());
		}
	}
	
}
