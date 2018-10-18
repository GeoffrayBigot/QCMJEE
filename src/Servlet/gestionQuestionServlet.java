package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.GestionQuestions;
import bo.Proposition;
import bo.Question;
import bo.Theme;
import bo.Utilisateur;

/**
 * Servlet implementation class gestionQuestionServlet
 */
public class gestionQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestionQuestions gestionQuestions = new GestionQuestions();
	public static final String VUE = "/WEB-INF/jsp/gestionQuestion.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public gestionQuestionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Utilisateur userConnected = (Utilisateur) session.getAttribute("isConnected");
		if (userConnected != null) {

			actualiseQuestion(session);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		} else {
			response.sendRedirect("http://localhost:8080/QCMJEE/accueil");
		}

	}

	public void actualiseQuestion(HttpSession session) {

		try {
			ArrayList<Question> questions = gestionQuestions.selectAllQuestion();
			ArrayList<Proposition> propositions = gestionQuestions.selectAllReponse();
			ArrayList<Theme> themes = gestionQuestions.selectAllTheme();
			session.setAttribute("listQuestion", questions);
			session.setAttribute("listReponse", propositions);
			session.setAttribute("listTheme", themes);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titreQ = request.getParameter("titreQ");
		int nbP = Integer.parseInt(request.getParameter("nbP"));
		String typeQ = request.getParameter("typeQ");
		int theme = Integer.parseInt(request.getParameter("theme"));
		int nbR = Integer.parseInt(request.getParameter("nbR"));
		int idRep = 0;

		if (typeQ.equals("typeRadio")) {
			idRep = Integer.parseInt(request.getParameter("rep-valide-radio"));
		}

		ArrayList<String> ennonce = new ArrayList<>();
		ArrayList<Boolean> reps = null;

		if (typeQ.equals("typeCheckbox")) {
			reps = new ArrayList<>();
		}

		for (int i = 1; i <= nbR; i++) {
			ennonce.add(request.getParameter("rep-" + i));
			if (reps != null) {
				System.out.println(request.getParameter("rep-valide-" + i));
				if (request.getParameter("rep-valide-" + i) != null) {
					reps.add(true);
				} else {
					reps.add(false);
				}
			}
		}

		ArrayList<Proposition> reponses = new ArrayList<>();

		if (reps != null) {
			for (int i = 0; i < nbR; i++) {
				reponses.add(new Proposition(ennonce.get(i), reps.get(i)));
			}
		} else {
			for (String s : ennonce) {
				if (ennonce.indexOf(s) + 1 == idRep) {
					reponses.add(new Proposition(s, true));
				} else {
					reponses.add(new Proposition(s, false));
				}
			}
		}

		byte[] img = new byte[0];

		try {
			gestionQuestions.ajouterQuestion(titreQ, img, nbP, theme, reponses);
		} catch (SQLException e) {
			e.getMessage();
		}

		HttpSession session = request.getSession();

		actualiseQuestion(session);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
