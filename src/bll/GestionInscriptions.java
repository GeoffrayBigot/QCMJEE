package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Utilisateur;
import dal.UtilisateurDAOJdbcImpl;

public class GestionInscriptions {

	private static UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
	
	public  void inscriptionUser(String nom,String prenom,String email,String password, int codeProfil,String codePromo) throws SQLException {
		try {
			utilisateurDAO.insertUtilisateur(new Utilisateur(nom, prenom, email, password, codeProfil, codePromo));
		} catch (SQLException e) {
			throw new SQLException("probleme GestionInscription fermeture connexion" + e.getMessage());
		}
	}
	
	public ArrayList<Utilisateur> SelectAllUser() throws SQLException {
		try {
			return utilisateurDAO.selectAll();
		} catch (SQLException e) {
			throw new SQLException("probleme GestionInscription fermeture connexion" + e.getMessage());
		}
	}
	
	public Utilisateur selectByIdUtilisateur(int idUtilisateur) throws SQLException {
		try {
			return utilisateurDAO.selectById(idUtilisateur);
		} catch (SQLException e) {
			throw new SQLException("probleme GestionInscription fermeture connexion" + e.getMessage());
		}
	}
	
	public void miseAJourUtilisateur(Utilisateur userUpdate) throws SQLException {
		try {
			utilisateurDAO.updateUtilisateur(userUpdate);
		} catch (SQLException e) {
			throw new SQLException("probleme GestionInscription fermeture connexion" + e.getMessage());
		}
	}
}
