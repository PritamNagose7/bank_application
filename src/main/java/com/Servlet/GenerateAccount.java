package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Account;
import com.Model.Queries;


@WebServlet("/GenerateAccount")
public class GenerateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GenerateAccount() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String accountnumber = request.getParameter("accountnumber");
		String account_no = request.getParameter("account_no");
		String password = request.getParameter("password");
		
		Account a = new Account();
		a.setName(name);
		a.setAccountnumber(accountnumber);
		a.setAccount_no(account_no);
		a.setPassword(password);
		
		int status = Queries.save(a);
		if(status>0)
		{
			  out.print("<p> Record saved successfully ! </p>");
			  request.getRequestDispatcher("Login.html").include(request, response);
		}else 
		{
			out.println("Sorry ! unable to save record");
		}
	
		out.close();
	}

}
