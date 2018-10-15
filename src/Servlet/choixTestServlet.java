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
import bll.GestionTest;
import bo.Epreuve;
import bo.Utilisateur;

/**
 * Servlet implementation class choixTestServlet
 */
public class choixTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestionEpreuve gestionEpreuve = new GestionEpreuve();
	public static final String VUE = "/WEB-INF/jsp/choixTest.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public choixTestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		Utilisateur userCo = (Utilisateur) session.getAttribute("isConnected");
		
		ArrayList<Epreuve> epreuves;
		try {
			epreuves = gestionEpreuve.selectEpreuvesByIdUtilisateur(userCo.getIdUser());
			session.setAttribute("listEpreuve", epreuves);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	
	}
		
}
