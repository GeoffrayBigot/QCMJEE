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
    public static final String VUE = "/index.jsp";
       	
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
		HttpSession session = request.getSession();
		System.out.println(session);
		if(session.getId() == null) {
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}else{
			response.sendRedirect("http://localhost:8080/QCMJEE/accueil");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email  = request.getParameter("email");
		String mdp = request.getParameter("password");
		
		Utilisateur user = null;
		try {
			user = GestionConnexion.connexion(email, mdp);		
			
			HttpSession session = request.getSession();		
			if(user.getIdUser() > 0 ){
				String isConnected = "1";
				session.setAttribute("isConnected", isConnected);
				session.setAttribute("userNom", user.getNom());
				session.setAttribute("userPrenom", user.getPrenom());
				
				response.sendRedirect("http://localhost:8080/QCMJEE/accueil");
			}else{
				session.setAttribute("sessionUtilisateur", null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
