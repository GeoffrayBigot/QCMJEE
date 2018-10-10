package dal;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Utilisateur;

public class testDAO {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Utilisateur> select = UtilisateurDAOJdbcImpl.select();
		Utilisateur utilisateur = select.get(0);
		System.out.println(utilisateur.getPrenom()+  " "+utilisateur.getNom());
	}

}
