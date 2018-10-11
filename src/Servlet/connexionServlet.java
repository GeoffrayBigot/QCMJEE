package Servlet;

import java.io.IOException;
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
		Utilisateur userConnected = (Utilisateur) session.getAttribute("isConnected");		
		if(userConnected == null){
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
	    Map<String, String> erreurs = new HashMap<String, String>();
	    HttpSession session = request.getSession();			
		Utilisateur user = null;
		
		try {
			gestionConnexion.validationEmail(email);
		} catch (Exception e) {
			erreurs.put("email", e.getMessage());
		}
		try {
			gestionConnexion.validationMotsDePasse(mdp);
		} catch (Exception e) {
			erreurs.put("password", e.getMessage());
		}		
		
		try {				
			user = gestionConnexion.connexion(email, mdp);		
				
			if(user.getIdUser() > 0 ){
				session.setAttribute("isConnected", user);
				session.setAttribute("userNom", user.getNom());
				session.setAttribute("userPrenom", user.getPrenom());				
				response.sendRedirect("http://localhost:8080/QCMJEE/accueil");
			}else{
				session.setAttribute("isConnected", null);
			}
		} catch (Exception e) {
			erreurs.put("user", e.getMessage());
			
		}
		session.setAttribute("erreurs", erreurs);	
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

}
