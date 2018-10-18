package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bo.Epreuve;
import bo.EtatEpreuve;
import bo.NiveauAquisition;
import bo.Test;
import bo.Utilisateur;
import util.DBConnection;

public class EpreuveDAOJdbcImpl {

	private static final String insertEpreuve = "insert into Epreuve values(?,?,?,?,?,?,?,?);";
	private static final String selectByIdUser = "select e.dateDedutValidite, e.dateFinValidite, e.tempsEcoule, e.etat,e.note_obtenue,e.niveau_obtenu, test.idTest, test.libelle, test.description,test.duree, test.seuil_haut, test.seuil_bas, u.idUtilisateur, u.nom, u.prenom, u.email, u.password, u.codeProfil, u.codePromo, e.idEpreuve from EPREUVE e inner join Test test on e.idTest = test.idTest inner join Utilisateur u on u.idUtilisateur = e.idUtilisateur where e.idUtilisateur = ?;";
	private static final String updateNote = "update Epreuve set note_obtenue = ? where idEpreuve = ?;";
	private static final String selectById = "select e.dateDedutValidite, e.dateFinValidite, e.tempsEcoule, e.etat,e.note_obtenue,e.niveau_obtenu, test.idTest, test.libelle, test.description,test.duree, test.seuil_haut, test.seuil_bas, u.idUtilisateur, u.nom, u.prenom, u.email, u.password, u.codeProfil, u.codePromo, e.idEpreuve from EPREUVE e inner join Test test on e.idTest = test.idTest inner join Utilisateur u on u.idUtilisateur = e.idUtilisateur where e.idEpreuve = ?;";
	private static final String updateEtatEpreuve = "update Epreuve set etat = ? where idEpreuve = ?;";
	private static final String updateAquisitionEpreuve = "update Epreuve set niveau_obtenu = ? where idEpreuve = ?;";

	public static void insertEpreuve(Epreuve aEpreuve) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;

		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(insertEpreuve);

			stmt.setDate(1, aEpreuve.getDebutValidite());
			stmt.setDate(2, aEpreuve.getFinValidite());
			stmt.setInt(3, aEpreuve.getTempsEcoule());
			stmt.setString(4, aEpreuve.getEtatEpreuve().name());
			stmt.setDouble(5, aEpreuve.getNote());
			stmt.setString(6, aEpreuve.getNiveauAcquisition().name());
			stmt.setInt(7, aEpreuve.getTest().getIdTest());
			stmt.setInt(8, aEpreuve.getUser().getIdUser());

			stmt.execute();
			System.out.println("Insertion réalisée avec succès");

		} catch (SQLException e) {
			throw new SQLException("probleme EpreuveDAO methode insert" + e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme Epreuve fermeture connexion" + e.getMessage());
			}

		}

	}

	public ArrayList<Epreuve> selectbyIdUtilisateur(int idUtilisateur) throws SQLException {
		ArrayList<Epreuve> vListeEpreuves = new ArrayList<Epreuve>();

		Connection cnx = null;
		ResultSet rs = null;

		try {
			cnx = DBConnection.seConnecter();
			PreparedStatement prep1 = cnx.prepareStatement(selectByIdUser);
			prep1.setInt(1, idUtilisateur);
			rs = prep1.executeQuery();
			// traitement du rs
			NiveauAquisition vNiveau = NiveauAquisition.NA;
			EtatEpreuve vEtatEpreuve = EtatEpreuve.EA;

			while (rs.next()) {

				switch (rs.getString(6)) {
				case "NA ":
					vNiveau = NiveauAquisition.NA;
					break;
				case "A  ":
					vNiveau = NiveauAquisition.A;
					break;
				case "ECA":
					vNiveau = NiveauAquisition.ECA;
					break;

				default:
					break;
				}

				switch (rs.getString(4)) {
				case "T ":
					vEtatEpreuve = EtatEpreuve.T;
					break;
				case "EC":
					vEtatEpreuve = EtatEpreuve.EC;
					break;
				case "EA":
					vEtatEpreuve = EtatEpreuve.EA;
					break;

				default:
					break;
				}
				vListeEpreuves.add(new Epreuve(rs.getInt(20), rs.getDate(1), rs.getDate(2),
						new Test(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11),
								rs.getInt(12)),
						new Utilisateur(rs.getInt(13), rs.getString(14), rs.getString(15), rs.getString(16),
								rs.getString(17), rs.getInt(18), rs.getString(19)),
						vNiveau, vEtatEpreuve, rs.getInt(5)));
			}
		} catch (SQLException e) {
			throw new SQLException("probleme UtilisateurDAO methode selectById " + e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme UtilisateurDAO fermeture connexion" + e.getMessage());
			}
		}
		return vListeEpreuves;
	}

	public Epreuve selectbyId(int idEpreuve) throws SQLException {

		Connection cnx = null;
		ResultSet rs = null;
		Epreuve vEpreuve = null;

		try {
			cnx = DBConnection.seConnecter();
			PreparedStatement prep1 = cnx.prepareStatement(selectById);
			prep1.setInt(1, idEpreuve);
			rs = prep1.executeQuery();
			// traitement du rs
			NiveauAquisition vNiveau = NiveauAquisition.NA;
			EtatEpreuve vEtatEpreuve = EtatEpreuve.EA;

			while (rs.next()) {

				switch (rs.getString(6)) {
				case "NA ":
					vNiveau = NiveauAquisition.NA;
					break;
				case "A  ":
					vNiveau = NiveauAquisition.A;
					break;
				case "ECA":
					vNiveau = NiveauAquisition.ECA;
					break;

				default:
					break;
				}

				switch (rs.getString(4)) {
				case "T ":
					vEtatEpreuve = EtatEpreuve.T;
					break;
				case "EC":
					vEtatEpreuve = EtatEpreuve.EC;
					break;
				case "EA":
					vEtatEpreuve = EtatEpreuve.EA;
					break;

				default:
					break;
				}
				vEpreuve = new Epreuve(rs.getInt(20), rs.getDate(1), rs.getDate(2),
						new Test(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11),
								rs.getInt(12)),
						new Utilisateur(rs.getInt(13), rs.getString(14), rs.getString(15), rs.getString(16),
								rs.getString(17), rs.getInt(18), rs.getString(19)),
						vNiveau, vEtatEpreuve, rs.getInt(5));
			}
		} catch (SQLException e) {
			throw new SQLException("probleme UtilisateurDAO methode selectById " + e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme UtilisateurDAO fermeture connexion" + e.getMessage());
			}
		}
		return vEpreuve;
	}

	public static void updateNote(Epreuve epreuve) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;

		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(updateNote);

			stmt.setInt(1, epreuve.getNote());
			stmt.setInt(2, epreuve.getId());

			stmt.execute();
			System.out.println("Modification réalisée avec succès");

		} catch (SQLException e) {
			throw new SQLException("probleme EpreuveDAO methode updateNote" + e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme Epreuve fermeture connexion" + e.getMessage());
			}

		}

	}


	public static void updateEtatEpreuve(Epreuve epreuve) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;

		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(updateEtatEpreuve);

			stmt.setString(1, epreuve.getEtatEpreuve().name());
			stmt.setInt(2, epreuve.getId());

			stmt.execute();
			System.out.println("Modification réalisée avec succès");

		} catch (SQLException e) {
			throw new SQLException("probleme EpreuveDAO methode updateNote" + e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme Epreuve fermeture connexion" + e.getMessage());
			}
		}

	}

	public static void updateAquisitionEpreuve(Epreuve epreuve) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;

		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(updateAquisitionEpreuve);

			stmt.setString(1, epreuve.getNiveauAcquisition().name());
			stmt.setInt(2, epreuve.getId());

			stmt.execute();
			System.out.println("Modification réalisée avec succès");

		} catch (SQLException e) {
			throw new SQLException("probleme EpreuveDAO methode updateNote" + e.getMessage());
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new SQLException("probleme Epreuve fermeture connexion" + e.getMessage());
			}

		}

	}

}
