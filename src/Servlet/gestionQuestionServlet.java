package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.GestionConnexion;
import bll.GestionQuestions;
import bo.Proposition;
import bo.Question;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		
		try {
			ArrayList<Question> questions = gestionQuestions.selectAllQuestion();
			ArrayList<Proposition> propositions = gestionQuestions.selectAllReponse();
			session.setAttribute("listQuestion", questions);
			session.setAttribute("listReponse", propositions);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	 

}
