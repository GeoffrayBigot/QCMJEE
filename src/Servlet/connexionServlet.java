package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.GestionConnexion;
import bo.Utilisateur;

/**
 * Servlet implementation class connexionServlet
 */
public class connexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestionConnexion gestionConnexion = new GestionConnexion();
	public static final String VUE = "/WEB-INF/jsp/connexion.jsp";
	private Map<String, String> erreurs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public connexionServlet() {
		super();
		erreurs = new HashMap<String, String>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur userConnected = (Utilisateur) session.getAttribute("isConnected");
		if (userConnected == null) {
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} else {
			response.sendRedirect("http://localhost:8080/QCMJEE/accueil");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("password");
		HttpSession session = request.getSession();
		Utilisateur user = null;

		if (verifs(email, mdp)) {
			try {
				System.out.println("Je suis dans le try");
				gestionConnexion.validationUtilisateur(email, mdp);
				System.out.println("Mon User Existe !");
				user = gestionConnexion.connexion(email, mdp);
				if (user.getIdUser() > 0) {
					System.out.println(user);
					session.setAttribute("isConnected", user);
					session.setAttribute("userNom", user.getNom());
					session.setAttribute("userPrenom", user.getPrenom());
					session.setAttribute("userProfil", user.getProfil().getLibelle());
					choixPage(user, response);
				} else {
					session.setAttribute("isConnected", null);
				}
			} catch (Exception e) {
				erreurs.put("user", e.getMessage());
				session.setAttribute("erreurs", erreurs);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			}
		} else {
			session.setAttribute("erreurs", erreurs);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
	}

	public void choixPage(Utilisateur user, HttpServletResponse response) throws IOException {
		switch (user.getProfil().getLibelle()) {
		case "Formateur":
			response.sendRedirect("http://localhost:8080/QCMJEE/accueil");
			break;
		case "Responsable":
			response.sendRedirect("http://localhost:8080/QCMJEE/accueil");
			break;
		case "Etudiant":
			response.sendRedirect("http://localhost:8080/QCMJEE/choixTest");
			break;
		default:
			response.sendRedirect("http://localhost:8080/QCMJEE/accueil");
		}
	}

	public boolean verifs(String email, String pass) {
		boolean verifs = false;
		boolean emailVerif = false, mdpVerif = false;
		try {
			gestionConnexion.validationEmail(email);
			emailVerif = true;
		} catch (Exception e) {
			erreurs.put("email", e.getMessage());
		}
		try {
			gestionConnexion.validationMotsDePasse(pass);
			mdpVerif = true;
		} catch (Exception e) {
			erreurs.put("password", e.getMessage());
		}
		if (emailVerif && mdpVerif) {
			verifs = true;
		}
		return verifs;
	}
}
