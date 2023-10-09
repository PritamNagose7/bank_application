package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.LoginValidation;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String account_no = request.getParameter("account_no");
		String password = request.getParameter("password");
	
		if (LoginValidation.Validation(account_no, password)) {
			// HttpSession Session = request.getSession();

			out.print("<p> Login successfully ! </p>");
			request.getRequestDispatcher("welcome.html").include(request, response);
			
			// RequestDispatcher rdt = request.getRequestDispatcher("welcome.html");
			//rdt.forward(request, response);

		} else {
			
			out.println("<p> Sorry ! unable to save record </p> ");
			request.getRequestDispatcher("Login.html").include(request, response);
			
			//RequestDispatcher rdt = request.getRequestDispatcher("index.html");
			//rdt.forward(request, response);
		}

		out.close();
	}

}
