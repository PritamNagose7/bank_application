package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Emp;
import com.Model.Queries;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email_address = request.getParameter("email_address");
		Double mobile_no = Double.parseDouble(request.getParameter("mobile_no"));
		Double aadhar_no = Double.parseDouble(request.getParameter("aadhar_no"));
		String address = request.getParameter("address");
		

		Emp e = new Emp();
		e.setFirst_name(first_name);
		e.setLast_name(last_name);
		e.setEmail_address(email_address);
		e.setMobile_no(mobile_no);
		e.setAadhar_no(aadhar_no);
		e.setAddress(address);
		
		int status = Queries.save(e);
		if(status>0)
		{
			  out.print("<p> Record saved successfully ! </p>");
			  request.getRequestDispatcher("GenerateAccount.html").include(request, response);
		}else 
		{
			out.println("Sorry ! unable to save record");
		}
	
		out.close();
	}

}
