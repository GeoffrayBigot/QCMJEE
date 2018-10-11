package bll;

import bo.Utilisateur;
import dal.UtilisateurDAOJdbcImpl;

public class GestionConnexion {

	private static UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
	
	public static Utilisateur connexion(String eMail, String pass) throws Exception {
		Utilisateur user = null ;
		
		if(validationEmail(eMail)) {
			if(validationMotsDePasse(pass)) {
			 user = utilisateurDAO.selectConnection(eMail, pass);
			}else {
				throw new Exception("Votre Mot de Passe est incorrect !");
			}
		} else {
			throw new Exception("Votre Email est incorrect !");
		}
		return user;			
	}

	/**
	 * Valide l'adresse mail saisie.
	 */
	private static boolean validationEmail( String email ) throws Exception {
	    if ( email != null && email.trim().length() != 0 ) {
	        	return true;
	    } else {
	        return false;
	    }
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	private static boolean validationMotsDePasse( String motDePasse) throws Exception{
	    if (motDePasse != null && motDePasse.trim().length() != 0 ) {
	        	return true;
	    } else {
	    	return false;
	    }
	}

	
}
