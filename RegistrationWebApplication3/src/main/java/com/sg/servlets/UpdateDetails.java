package com.sg.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sg.registerdaoimpl.RegistrationDAOImpl;
import com.sg.registrationmodelclass.Registration;

/**
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RegistrationDAOImpl rdaoi = new RegistrationDAOImpl();
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String dobString = req.getParameter("dob");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		LocalDate dob = null;
		if (dobString != null && !dobString.isEmpty()) {
			dob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		
		Registration reg = new Registration();
		reg.setId(id);
		reg.setName(name);
		reg.setEmail(email);
		reg.setDob(dob);
		reg.setPhone(phone);
		reg.setAddress(address);
		
		int x = rdaoi.updateData(reg);
		
		if(x == 1)
		{
			resp.sendRedirect("FetchAll");
		}
		else
		{
			resp.sendRedirect("failure.jsp");		}
		
	}

}
