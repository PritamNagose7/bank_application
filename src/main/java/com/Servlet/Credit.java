package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Account;
import com.Util.DBConnection;


@WebServlet("/Credit")
public class Credit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Credit() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Credit</h1>");
		String Accountnumber = request.getParameter("accountnumber");
		// String id = request.getParameter("id");
		
		//int balanceid = Integer.parseInt(id);
		System.out.println("Account+......+"+Accountnumber);
		Account acn = new Account();
		
		try {
			Connection con = DBConnection.GetConnection();
			PreparedStatement ps = con.prepareStatement("select * from account where accountnumber=?");
			ps.setString(1, Accountnumber);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				acn.setAccountnumber(rs.getString(2));
				System.out.println(rs.getString(2));
				acn.setBalance(rs.getInt(5));
				System.out.println(rs.getInt(5));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("<head>");
		out.print("<script>\r\n" + 
				"function add(){\r\n" + 
				"var a,b,c;\r\n" + 
				"a=Number(document.getElementById(\"first\").value);\r\n" + 
				"b=Number(document.getElementById(\"second\").value);\r\n" + 
				"c= a + b;\r\n" + 
				"document.getElementById(\"answer\").value= c;\r\n" + 
				"}\r\n" + 
				"</script>");
		out.print("</head>");

			out.println("<body>");
			out.print("<form action='CreditServlet'method='post'>");
			out.print("<table>");
			out.print("<tr><td></td><td><input type='text' name='accountnumber'  value='"+acn.getAccountnumber()+"'/></td></tr>");
			out.print("<tr><td>Current Balance:</td><td><input type='text' id ='first' name='name' value='"+acn.getBalance()+"'/></td></tr>");
			out.print("<tr><td>Credit:</td><td><input type='number'id='second' name='new'></td></tr>");
			out.print("<tr><td>Total:</td><td><input type='number' id='answer' name='Balance'></td></tr>");
			out.print("<button onclick=\"add()\">Credit</button>");
			out.print("</form>");
			
			//out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");

			out.print("</table>");
			
			
			out.println("</body>");
		
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
