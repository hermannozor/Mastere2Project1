package com.mastere1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String action = req.getPathInfo();
		
		if (action == null){
			resp.sendError(404, "L'action demandée n'est pas prise en charge.");
		}
		switch (action) {
		case "/google":
		resp.sendRedirect("http://www.google.com");
		break;
		case "/bonjour":
			req.getRequestDispatcher("/WEB-INF/views/test/bonjour.jsp").forward(req, resp);
		break;
		case "/formulaire":
			req.getRequestDispatcher("/WEB-INF/views/test/formulaire.jsp").forward(req, resp);
		break;
		default:
			resp.sendError(404, "L'action demandée n'est pas prise en charge.");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String action = req.getPathInfo();
		
		if (action == null){
			resp.sendError(404, "L'action demandée n'est pas prise en charge.");
		}
		if(action.equals("/formulaire")){
			String nom = req.getParameter("inputNom");
			String prenom =  req.getParameter("inputPrenom");
			String chaine = "Bonjour "+ nom + " " + prenom;
			req.setAttribute("maChaine", chaine);
			req.getRequestDispatcher("/WEB-INF/views/test/resultat.jsp").forward(req, resp);
			return;
		}
		resp.sendError(404, "L'action demandée n'est pas prise en charge."); 
	}
	

}
