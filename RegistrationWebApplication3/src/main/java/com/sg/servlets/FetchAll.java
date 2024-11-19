package com.sg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.registerdaoimpl.RegistrationDAOImpl;
import com.sg.registrationmodelclass.Registration;

/**
 * Servlet implementation class FetchAll
 */

public class FetchAll extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RegistrationDAOImpl rdaoi = new RegistrationDAOImpl();
		
		ArrayList<Registration> rList = rdaoi.fetchAll();
		
//		for(Registration r : rList)
//		{
//			PrintWriter pw = resp.getWriter();
//			pw.println(r.getName());
//			pw.println(r.getEmail());
//			pw.println(r.getDob());
//			
//		}
		
		req.getSession().setAttribute("rList", rList);
		resp.sendRedirect("home.jsp");
		
		
	}

}
