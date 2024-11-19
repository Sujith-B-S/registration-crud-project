package com.sg.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.backend.Sender;

import com.sg.registerdaoimpl.RegistrationDAOImpl;
import com.sg.registrationmodelclass.Registration;

/**
 * Servlet implementation class AddRegister
 */
@WebServlet("/AddRegister")
public class AddRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Retrieve form parameters
		RegistrationDAOImpl rdaoi = new RegistrationDAOImpl();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String dobString = req.getParameter("dob"); // Get dob as a String
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");

		// Convert dobString to LocalDate
		LocalDate dob = null;
		if (dobString != null && !dobString.isEmpty()) {
			dob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}

		// Create a Registration object
		Registration reg = new Registration();
		reg.setName(name);
		reg.setEmail(email);
		reg.setDob(dob); // Assuming your Registration class uses LocalDate
		reg.setPhone(phone);
		reg.setAddress(address);
		
		int x = rdaoi.insertData(reg);
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
