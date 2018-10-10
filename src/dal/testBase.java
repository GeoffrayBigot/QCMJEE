package dal;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Profil;
import bo.Promotion;
import bo.Utilisateur;

public class testBase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*ArrayList<Promotion> selectPromo = PromotionDAOJdbcImpl.selectAll();
		for(Promotion p : selectPromo) {
			System.out.println(p.getCodePromotion()+  " "+p.getLibelle());			
		}
		
		System.out.println("==============================");
		ArrayList<Profil> selectProfil = ProfilDAOJdbcImpl.selectAll();
		for(Profil p : selectProfil) {
			System.out.println(p.getCodeProfil()+  " "+p.getLibelle());			
		}
		
		System.out.println("==============================");
		ArrayList<Utilisateur> selectUtilisateur = UtilisateurDAOJdbcImpl.selectAll();
		for(Utilisateur p : selectUtilisateur) {
			System.out.println(p.getNom()+ " "+p.getPrenom() +" "+p.getEmail() + " "
					+p.getPassword()+" " +p.getProfil()+ " "+p.getPromotion());			
		}
		System.out.println("==============================");
		Utilisateur userCo = UtilisateurDAOJdbcImpl.selectConnection("geoffray@bigot.com", "TestMdp");
		System.out.println(userCo.getNom()+" "+userCo.getPrenom());
			
		/System.out.println("==============================");
		userCo.setPrenom("GEOFFRAY");
		UtilisateurDAOJdbcImpl.updateUtilisateur(userCo);
		ArrayList<Utilisateur> selectUtilisateur = UtilisateurDAOJdbcImpl.selectAll();
		for(Utilisateur p : selectUtilisateur) {
			System.out.println(p.getNom()+ " "+p.getPrenom() +" "+p.getEmail() + " "
					+p.getPassword()+" " +p.getProfil()+ " "+p.getPromotion());			
		}*/
		
		
	}
}
