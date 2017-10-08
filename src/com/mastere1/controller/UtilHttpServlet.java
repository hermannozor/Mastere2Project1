package com.mastere1.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UtilHttpServlet extends HttpServlet {

	protected String action="";
	private HttpServletRequest req = null;
	private HttpServletResponse resp = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.req = req;
		this.resp = resp;
		this.action = req.getPathInfo();
		try {
			Method method = this.getClass().getMethod(action.substring(1));
			
			try {
				method.invoke(this);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.req = req;
		this.resp = resp;
		this.action = req.getPathInfo();
		try {
			Method method = this.getClass().getMethod(action.substring(1));
			
			try {
				method.invoke(this);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void displayView(final String viewName, final String controllerName){
		String controller = controllerName == null ? null : controllerName;
		
		if (controller == null){
			controller = this.getClass().getSimpleName();
			controller = controller.substring(controller.lastIndexOf("Servlet")+7).toLowerCase();
		}
		try{
			final String dir = "/WEB-INF/views/" + controller + "/" + viewName + ".jsp";
			req.getRequestDispatcher(dir).forward(this.req, this.resp);	
		}
		catch (Exception e){
			try {
				this.resp.sendError(405, "La vue "+ viewName + " est introuvable");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
	}
	
	protected void displayView(Object model){
		String viewName="";
		String controller="";
	
			controller = this.getClass().getSimpleName();
			controller = controller.substring(controller.lastIndexOf("Servlet")+7).toLowerCase();
			try {
				viewName = this.getClass().getMethod(this.action.substring(1)).getName();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		try{
			if(model != null){
				req.setAttribute("monModel", model);
			}
			final String dir = "/WEB-INF/views/" + controller + "/" + viewName + ".jsp";
			req.getRequestDispatcher(dir).forward(this.req, this.resp);	

		}
		catch (Exception e){
			try {
				this.resp.sendError(405, "La vue "+ viewName + " est introuvable");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
	}
}
