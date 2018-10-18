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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> idQuestions = new ArrayList<>();
		ArrayList<String> idReponsesSaisies = new ArrayList<>();
		ArrayList<Proposition> propositionsAttendues = new ArrayList<>();
		int nbQuestions = Integer.parseInt(request.getParameter("nbQuestions"));
		HashMap<Integer, ArrayList<Integer>> vMapQuestionReponses= new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> vQuestionBonne= new ArrayList<Integer>();
		ArrayList<Integer> vPropositionsOk = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> vMapReponsesDonnees= new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, Integer> vNbRepsParQuestion= new HashMap<Integer, Integer>();
		HttpSession session = request.getSession();
		int nbRepsFormulaire=0;
		Epreuve vEpreuve = null;
		int repEnCours = 0; 
		//On recupere l'epreuve
		try { 
			vEpreuve = gestionEpreuve.selectById(Integer.parseInt(request.getParameter("idEpreuve")));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		for (int i = 1; i < nbQuestions; i++) {
			try {
				nbRepsFormulaire+= gestionQuestions.selectPropositionByIdQuestion(i).size();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		for(int i=0;i<=nbRepsFormulaire;i++){
			String param  = request.getParameter(String.valueOf(i));

			if(null!=param){
			idReponsesSaisies.add(param);
			}
		}
		//On recupere les id des questions et les propositions attendues
		for (int i = 1; i < nbQuestions; i++) {
			String parameter = request.getParameter("q-" + i);
			idQuestions.add(parameter);

			try {
//				Question vQuestion = gestionQuestions.selectQuestionById(Integer.parseInt(parameter));
				
				int idQuestion = Integer.parseInt(parameter);
				ArrayList<Proposition> selectPropositionByIdQuestion = gestionQuestions.selectPropositionByIdQuestion(idQuestion);
				

				propositionsAttendues.addAll(selectPropositionByIdQuestion);
				vPropositionsOk.removeAll(vPropositionsOk);
				int nbReponses = selectPropositionByIdQuestion.size();
				vNbRepsParQuestion.put(idQuestion,nbReponses);
				for(Proposition iProposition : selectPropositionByIdQuestion){
					if(iProposition.isEstCorrecte()){
						vPropositionsOk.add(iProposition.getIdReponse());
					}
				}
				vMapQuestionReponses.put(idQuestion,vPropositionsOk);
				vMapReponsesDonnees.put(idQuestion,new ArrayList<>());
				for(int j = 0; j<gestionQuestions.selectPropositionByIdQuestionWhereTrue(idQuestion).size();j++){
					vMapReponsesDonnees.get(idQuestion).add(Integer.valueOf(idReponsesSaisies.get(repEnCours)));
					repEnCours++;
				}		
				if(vMapQuestionReponses.get(idQuestion).equals(vMapReponsesDonnees.get(idQuestion))){
					vQuestionBonne.add(idQuestion);
				}
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		ArrayList<Question> vToutesQuestions = new ArrayList<>();
		try {
			vToutesQuestions = gestionQuestions.selectAllQuestion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		vEpreuve.setEtatEpreuve(EtatEpreuve.T);
		
		for(int id : vQuestionBonne){
			Question q;
			try {
				q = gestionQuestions.selectQuestionById(id);
				vEpreuve.setNote(vEpreuve.getNote() +q.getPoint());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			gestionEpreuve.setEtat(vEpreuve);
			gestionEpreuve.setNote(vEpreuve);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("epreuve", vEpreuve);
		session.setAttribute("QuestionsCorrectes", vQuestionBonne);
		session.setAttribute("AllQuestions", vToutesQuestions);
		
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

}
