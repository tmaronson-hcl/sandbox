package com.hcl.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.hcl.dao.DAOFilms;
import com.hcl.dao.DAOFilmsImpl;

@WebServlet("/JDBCDsExampleServlet")
public class JDBCDsExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Maybe move some code out of HTTP method
	 * 1. Not really using class loader with type 4 Driver class.
	 * 2. Let's not use this DriverManager and see what happens.
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFilms films = new DAOFilmsImpl();
		List<String[]> results = films.getActors();
		request.setAttribute("actors", results);
		request.setAttribute("firstname", request.getParameter("firstname"));
		request.setAttribute("lastname", request.getParameter("lastname"));
		RequestDispatcher rd = request.getRequestDispatcher("/view/actors.jsp");
		rd.forward(request, response);
	}

	
}
