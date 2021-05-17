package com.hcl.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActorServlet
 */
//@WebServlet(description = "initial description of another servlet", urlPatterns = { "/ActorServlet" })
//public class ActorServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		/* What do we want to do here? Result is get all data from DB table.
//		 * 1. Make sure welcome-page to app hits this servlet. See above annotation. action attribute of jsp page.
//		 * 2. What do we want in servlet? What does servlet do? (requests and responses)
//		 * 3. Can I put or code any other methods in a servlet? yes
//		 * 4. If so what other methods do I include? Do DB stuff like with JDBC.
//		 * 5. Should I try a method that accesses DB? getData()?
//		 */
//		getConnection();
//		// What would I do if I have a new DB class to take responsibility of Model/Data? instantiate new class
//		// Send response with data to JSP.
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//	
//	void getConnection() { // refactor to another class? DAO interface (program to interface)
//		// other code to get connection Connection conn = 
//		getDbResults();
//	}
//
//	private void getDbResults(Connection conn) {
//		// process results with connection above
//	}
//
//}
