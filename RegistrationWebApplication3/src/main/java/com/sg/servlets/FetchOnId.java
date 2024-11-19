package com.sg.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.registerdaoimpl.RegistrationDAOImpl;
import com.sg.registrationmodelclass.Registration;

/**
 * Servlet implementation class FetchOnId
 */
@WebServlet("/FetchOnId")
public class FetchOnId extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		PrintWriter pw = resp.getWriter();
		
		
		RegistrationDAOImpl rdaoi = new RegistrationDAOImpl();
		Registration reg =  rdaoi.fetchAllId(id);
//		pw.println(r.getName());
		
		req.getSession().setAttribute("reg", reg);	
		resp.sendRedirect("editData.jsp");
		
	}

}
