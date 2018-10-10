package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.GestionConnexion;
import bo.Utilisateur;
import dal.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class connexionServlet
 */
public class connexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE = "/WEB-INF/jsp/connexion.jsp";
    public static final String ACCUEIL = "/index.jsp";
       	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email  = request.getParameter("email");
		String mdp = request.getParameter("password");
		
		try {
			Utilisateur user = GestionConnexion.connexion(email, mdp);
			HttpSession session = request.getSession();
			if(user.getIdUser() > 0 ){
				session.setAttribute("userNom", user.getNom());
				session.setAttribute("userPrenom", user.getPrenom());
				
				response.sendRedirect("http://localhost:8080/QCMJEE/");
			}else{
				session.setAttribute("sessionUtilisateur", null);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

}
