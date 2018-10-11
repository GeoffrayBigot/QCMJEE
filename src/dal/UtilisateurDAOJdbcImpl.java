package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Profil;
import bo.Promotion;
import bo.Utilisateur;
import util.DBConnection;

public class UtilisateurDAOJdbcImpl {

	private static final String selectUsers = "Select * from Utilisateur;";
	private static final String selectConnection = "Select idUtilisateur, nom, prenom, eMail, password from Utilisateur where email =? and password =?;";
	private static final String updateUser = "update Utilisateur set nom = ?, prenom = ?, eMail = ?, password = ? where idUtilisateur = ?";
	private static final String insertUser ="insert into Utilisateur values(?,?,?,?,?,?)";
	
	public ArrayList<Utilisateur> selectAll() throws SQLException {
		Utilisateur unUtilisateur = null;
		ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(selectUsers);
			// traitement du rs
			while (rs.next()) {
				unUtilisateur = new Utilisateur(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				utilisateurs.add(unUtilisateur);
			}
		} catch (SQLException e) {
			throw new SQLException("probleme UtilisateurDAO methode lister" + e.getMessage());
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme UtilisateurDAO fermeture connexion" + e.getMessage());
			}
		}
		return utilisateurs;
	}

	public Utilisateur selectConnection(String eMail, String pass) throws SQLException {
		Utilisateur user = null;

		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(selectConnection);
			stmt.setString(1, eMail);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = new Utilisateur(rs.getInt("idUtilisateur"), rs.getString("nom"), rs.getString("prenom"), rs.getString("eMail"),
						rs.getString("password"));
			}
		}catch (SQLException e) {
			throw new SQLException("probleme UtilisateurDAO fermeture connexion" + e.getMessage());
		} finally {
			stmt.close();
			cnx.close();
		}
		return user;
	}
	
	public void updateUtilisateur(Utilisateur user) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(updateUser);
			stmt.setString(1, user.getNom());
			stmt.setString(2, user.getPrenom());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setInt(5, user.getIdUser());
			stmt.execute();
			System.out.println("Update avec succès !");
		}  catch (SQLException e) {
			throw new SQLException("probleme UtilisateurDAO fermeture connexion" + e.getMessage());
		}  finally {
			stmt.close();
			cnx.close();
		}
	}

	public void insertUtilisateur(Utilisateur user) throws SQLException  {
		Connection cnx = null;
		PreparedStatement stmt = null;
		
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(insertUser);
			stmt.setString(1, user.getNom());
			stmt.setString(2, user.getPrenom());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setInt(5, user.getProfil().getCodeProfil());
			stmt.setString(6, user.getPromotion().getCodePromotion());
			stmt.execute();
			System.out.println("Insert avec succès !");
		} catch (SQLException e) {
			throw new SQLException("probleme UtilisateurDAO fermeture connexion" + e.getMessage());
		} finally {
			stmt.close();
			cnx.close();
		}

	}
}
