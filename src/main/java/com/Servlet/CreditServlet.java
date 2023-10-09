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


@WebServlet("/CreditServlet")
public class CreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String accountnumber=request.getParameter("accountnumber");
		int balance = Integer.parseInt(request.getParameter("Balance"));
		System.out.println(accountnumber);
		System.out.println(balance);
		
		Account e=new Account();
		e.setAccountnumber(accountnumber);
		e.setBalance(balance);
		int status=Queries.update(e);
		if(status>0){
			response.sendRedirect("View_Balance.html");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
