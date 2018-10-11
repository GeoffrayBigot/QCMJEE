package bll;

import bo.Utilisateur;
import dal.UtilisateurDAOJdbcImpl;

public class GestionConnexion {

	private static UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();

	public Utilisateur connexion(String eMail, String pass) throws Exception {
		Utilisateur user = utilisateurDAO.selectConnection(eMail, pass);
		return user;
	}

	/**
	 * Valide l'adresse mail saisie.
	 */
	public void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
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
		 if (motDePasse.trim().length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	public void validationUtilisateur(Utilisateur user) throws Exception {
		if (user == null) {
			throw new Exception("Le user n'est pas connu.");
		}
	}
}
