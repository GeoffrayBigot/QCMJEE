package bll;

import bo.Utilisateur;
import dal.ProfilDAOJdbcImpl;
import dal.UtilisateurDAOJdbcImpl;

public class GestionConnexion {

	private static UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
	private static ProfilDAOJdbcImpl profilDAO = new ProfilDAOJdbcImpl();

	public Utilisateur connexion(String eMail, String pass) throws Exception {
		Utilisateur user = utilisateurDAO.selectConnection(eMail, pass);
		user.setProfil(profilDAO.selectById(user.getProfil().getCodeProfil()));
		return user;
	}

	/**
	 * Valide l'adresse mail saisie.
	 */
	public void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if (!utilisateurDAO.selectCheckEmail(email).equals(email)) {
				throw new Exception("l'email n'existe pas.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	public void validationMotsDePasse(String motDePasse) throws Exception {
		if (motDePasse != null && motDePasse.trim().length() != 0) {
			if (!utilisateurDAO.selectCheckMdp(motDePasse).equals(motDePasse)) {
				throw new Exception("ce mot de passe n'existe pas.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	public void validationUtilisateur(String eMail, String pass) throws Exception {
		Utilisateur user = utilisateurDAO.selectConnection(eMail, pass);
		if (user == null) {
			throw new Exception("Le user n'est pas connu.");
		} 
	}
}
