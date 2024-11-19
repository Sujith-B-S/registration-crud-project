package com.sg.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.registerdaoimpl.RegistrationDAOImpl;

/**
 * Servlet implementation class DeleteOnId
 */
@WebServlet("/DeleteOnId")
public class DeleteOnId extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RegistrationDAOImpl rdaoi = new RegistrationDAOImpl();
		int id = Integer.parseInt(req.getParameter("id"));
		
//		PrintWriter pw = resp.getWriter();
//		pw.println(id);
		
		int x = rdaoi.deleteData(id);
		if(x == 1)
		{
			resp.sendRedirect("FetchAll");
		}
		else
		{
			resp.sendRedirect("failure.jsp");
		}
	}

}
