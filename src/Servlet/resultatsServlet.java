package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.GestionEpreuve;
import bll.GestionQuestions;
import bo.Epreuve;
import bo.EtatEpreuve;
import bo.Proposition;
import bo.Question;

/**
 * Servlet implementation class resultatsServlet
 */
public class resultatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/resultats.jsp";
	private GestionEpreuve gestionEpreuve = new GestionEpreuve();
	private GestionQuestions gestionQuestions = new GestionQuestions();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public resultatsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Epreuve vEpreuve = null;
		int nbQuestions = Integer.parseInt(request.getParameter("nbQuestions"));
		int nbRepsFormulaire = 0;
		
		ArrayList<String> idQuestions = new ArrayList<>();
		ArrayList<Proposition> propositionsAttendues = new ArrayList<>();

		HashMap<Integer, ArrayList<Integer>> vMapQuestionReponses = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> vQuestionBonne = new ArrayList<Integer>();
		ArrayList<Integer> vPropositionsOk = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> vMapReponsesDonnees = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, Integer> vNbRepsParQuestion = new HashMap<Integer, Integer>();
		HttpSession session = request.getSession();
		int repEnCours = 0;
		
		try {
			vEpreuve = recupEpreuve(request);
		} catch (SQLException e) {
			e.getMessage();
		}
	
		nbRepsFormulaire = nbQuestions(nbQuestions, nbRepsFormulaire);
		ArrayList<String> idReponsesSaisies = getReponsesCochees(request, nbRepsFormulaire);
		
		// On recupere les id des questions et les propositions attendues
		for (int i = 1; i < nbQuestions; i++) {
			String parameter = request.getParameter("q-" + i);
			idQuestions.add(parameter);

			try {
				int idQuestion = Integer.parseInt(parameter);
				ArrayList<Proposition> selectPropositionByIdQuestion = gestionQuestions
						.selectPropositionByIdQuestion(idQuestion);

				propositionsAttendues.addAll(selectPropositionByIdQuestion);
				vPropositionsOk.removeAll(vPropositionsOk);
				int nbReponses = selectPropositionByIdQuestion.size();
				vNbRepsParQuestion.put(idQuestion, nbReponses);
				for (Proposition iProposition : selectPropositionByIdQuestion) {
					if (iProposition.isEstCorrecte()) {
						vPropositionsOk.add(iProposition.getIdReponse());
					}
				}
				vMapQuestionReponses.put(idQuestion, vPropositionsOk);
				vMapReponsesDonnees.put(idQuestion, new ArrayList<>());
				
				for (int j = 0; j < gestionQuestions.selectPropositionByIdQuestionWhereTrue(idQuestion).size(); j++) {
					vMapReponsesDonnees.get(idQuestion).add(Integer.valueOf(idReponsesSaisies.get(repEnCours)));
					repEnCours++;
				}
				if (vMapQuestionReponses.get(idQuestion).equals(vMapReponsesDonnees.get(idQuestion))) {
					vQuestionBonne.add(idQuestion);
				}
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			setEtatNoteEpreuve(vEpreuve, vQuestionBonne);
		} catch (SQLException e) {
			e.getMessage();
		}

		ArrayList<Question> vToutesQuestions = addAllQuestionsEpreuves(idQuestions);
		
		session.setAttribute("epreuve", vEpreuve);
		session.setAttribute("QuestionsCorrectes", vQuestionBonne);
		session.setAttribute("AllQuestions", vToutesQuestions);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	private ArrayList<Question> addAllQuestionsEpreuves(ArrayList<String> idQuestions ) {
		ArrayList<Question> vToutesQuestions = new ArrayList<>();
		for(String i : idQuestions) {
			try {
				vToutesQuestions.add(gestionQuestions.selectQuestionById( Integer.parseInt(i)));
			} catch (NumberFormatException e) {
				e.getMessage();
			} catch (SQLException e) {
				e.getMessage();
			}
		}
		return vToutesQuestions;
	}

	private ArrayList<String> getReponsesCochees(HttpServletRequest request, int nbRepsFormulaire) {
		ArrayList<String> idReponsesSaisies = new ArrayList<>();
		for (int i = 0; i <= nbRepsFormulaire; i++) {
			String param = request.getParameter(String.valueOf(i));
			if (null != param) {
				idReponsesSaisies.add(param);
			}
		}
		return idReponsesSaisies;
	}

	private int nbQuestions(int nbQuestions, int nbRepsFormulaire) {
		for (int i = 1; i < nbQuestions; i++) {
			try {
				nbRepsFormulaire += gestionQuestions.selectPropositionByIdQuestion(i).size();
			} catch (SQLException e) {
				e.getMessage();
			}
		}
		return nbRepsFormulaire;
	}

	public Epreuve recupEpreuve(HttpServletRequest req) throws SQLException {
		try {
			 return gestionEpreuve.selectById(Integer.parseInt(req.getParameter("idEpreuve")));
		} catch (NumberFormatException | SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
	public void setEtatNoteEpreuve(Epreuve epr, ArrayList<Integer> idCorrects) throws SQLException {
		epr.setEtatEpreuve(EtatEpreuve.T);
		for (int id : idCorrects) {
			Question q;
			try {
				q = gestionQuestions.selectQuestionById(id);
				epr.setNote(epr.getNote() + q.getPoint());
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
		try {
			gestionEpreuve.setEtat(epr);
			gestionEpreuve.setNote(epr);
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
