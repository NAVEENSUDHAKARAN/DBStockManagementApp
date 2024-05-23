package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.ServerManager;
import com.chainsys.util.ConnectUtil;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServerManager manager = new ServerManager();
	UserData user = new UserData();
	UserDetails userDetails = new UserDetails();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		doGet(request, response);
		
		String name = request.getParameter("Name");
		String dob = request.getParameter("DOB");
		String empId = request.getParameter("EmpId");
		int number = Integer.parseInt(empId);
		userDetails.setName(name);
		userDetails.setDOB(dob);
		userDetails.setEmpId(empId);
		PrintWriter out = response.getWriter();

		request.setAttribute("data", userDetails);
		try {
			manager.insertToDB(userDetails);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("message : " + e.getMessage());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Display.jsp");
		dispatcher.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());		

		
		String choice = request.getParameter("action");
		if(choice.equals("delete"))
		{
			try {

				System.out.println("id: " + request.getParameter("id"));
				int id = Integer.parseInt(request.getParameter("id")); 
				ArrayList<UserDetails> list = manager.delete(id);
				request.setAttribute("list", list);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Display.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(choice.equals("update"))
		{
			try {
				System.out.println("hiii");
				System.out.println("id: " + request.getParameter("id"));
				int id = Integer.parseInt(request.getParameter("id"));
				
				System.out.println("Name: " + request.getParameter("upName"));
				String uptdName = request.getParameter("upName");
				ArrayList<UserDetails> upList = manager.update(id, uptdName);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Display.jsp");
				dispatcher.forward(request, response);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	
}
