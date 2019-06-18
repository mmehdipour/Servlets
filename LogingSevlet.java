package com.revature;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogingSevlet
 */
public class LogingSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogingSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		
		response.getWriter().append("Username:" + username + ", Password: "+ password);
	}

	String sql = "call createusers(?, ?, ?,?,?, ?)";
	CallableStatement ps = con.prepareCall(sql);
	ps.setInt(1, userID);
	ps.setString(2, name);
	ps.setString(3, password);
	ps.setDouble(4, initialFound);
	ps.setString(5, isAdmin);
	ps.execute();
	ps.registerOutParameter(6, Types.INTEGER);
	
 


}
