package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Util.DBConnection;


@WebServlet("/CreditSearch")
public class CreditSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CreditSearch() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String accountnumber = request.getParameter("accountnumber");
		System.out.println(accountnumber);

		try {

			Connection con = DBConnection.GetConnection();
			PreparedStatement ps = con.prepareStatement("select * from account where accountnumber=?");
			ps.setString(1, accountnumber);

			out.print("<table width=50% border=1>");
			out.print("<caption>Result:</caption>");

			ResultSet rs = ps.executeQuery();

			/* Printing column names */

			ResultSetMetaData rsmd = rs.getMetaData(); // column name
			int total = rsmd.getColumnCount();
			out.print("<tr>");

			for (int i = 1; i <= total; i++) {
				// array
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}

			out.print("</tr>");

			/* Printing result */

			if (rs.next()) {
				out.print("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getInt(2) + "</td><td>" + rs.getInt(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getInt(5));

			}

			out.print("</table>");
			
			out.print("<br><a href=\"welcome.html\"> <button type=\"button\">Click Home</button></a>");
			out.print("<td><a href='Credit?accountnumber="+rs.getString(2) + "'>Credit</a>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
