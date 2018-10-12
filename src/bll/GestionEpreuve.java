package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Epreuve;
import dal.EpreuveDAOJdbcImpl;

public class GestionEpreuve {


	private static EpreuveDAOJdbcImpl epreuvesDAO = new EpreuveDAOJdbcImpl();
	public Epreuve selectById(int idEpreuve) throws SQLException {
		try {
			return epreuvesDAO.selectbyId(idEpreuve);	

		} catch (SQLException e) {
			throw new SQLException("probleme GestionEpreuve fermeture connexion" + e.getMessage());
		}
	}
	public ArrayList<Epreuve> selectEpreuvesByIdUtilisateur(int idUtilisateur){
		try {
			return epreuvesDAO.selectbyIdUtilisateur(idUtilisateur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
