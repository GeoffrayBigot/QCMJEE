package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.GestionEpreuve;
import bll.GestionQuestions;
import bo.Epreuve;
import bo.Proposition;
import bo.Question;
import bo.QuestionEpreuve;
import bo.ReponseEpreuve;
import bo.Section;
import bo.Utilisateur;

/**
 * Servlet implementation class choixTestServlet
 */
public class passageTestServlet extends HttpServlet {

	private GestionEpreuve gestionEpreuve = new GestionEpreuve();
	private GestionQuestions gestionQuest = new GestionQuestions();
	public static final String VUE = "/WEB-INF/jsp/passageTest.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public passageTestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur userCo = (Utilisateur) session.getAttribute("isConnected");
		try {
			Epreuve epr = gestionEpreuve.selectById(Integer.parseInt(request.getParameter("idEpreuve")));
			ArrayList<Section> sections = gestionEpreuve.selectSelonTest(epr.getTest().getIdTest());
			addSectionToepreuve(sections, epr);
			generationQuestions(epr);
			System.out.println(epr);
		} catch (NumberFormatException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void addSectionToepreuve(ArrayList<Section> sections, Epreuve epr) {
		for (Section s : sections) {
			epr.getTest().ajouter(s.getTheme(), s.getNbQuestionsAttendues());
		}
	}

	public void generationQuestions(Epreuve epr) throws SQLException {
		ArrayList<Question> questions = null;
		ArrayList<Proposition> propositions = null;
		int ind = 0;
		int ordre = 1;
		QuestionEpreuve questionEpreuve;
		ArrayList<ReponseEpreuve> vReponsesEpreuves = new ArrayList<>();
		for (Section s : epr.getTest().getSections()) {
			if (s.getNbQuestionsAttendues() >= ind) {
				questions = gestionQuest.selectQuestionsByIdTheme(s.getTheme().getIdTheme());
				for (Question q : questions) {
					propositions = gestionQuest.selectPropositionByIdQuestion(q.getIdQuestion());
				}
				ind++;
			} else
				break;
		}
		for (Question q : questions) {
			questionEpreuve = new QuestionEpreuve(q.getIdQuestion(), q.getTheme().getIdTheme(), q.getEnonce(), null,
					q.getPoint());
			epr.ajouter(questionEpreuve);
			propositions = gestionQuest.selectPropositionByIdQuestion(q.getIdQuestion());
			for (Proposition p : propositions) {
				vReponsesEpreuves
						.add(new ReponseEpreuve(p.getIdReponse(), p.getLibelle(), p.isEstCorrecte(), epr.getId(), q.getIdQuestion()));
			}
			gestionQuest.ajouterQuestionEpreuve(questionEpreuve, epr.getId(), ordre, vReponsesEpreuves);
			ordre++;
		}
	}

}
