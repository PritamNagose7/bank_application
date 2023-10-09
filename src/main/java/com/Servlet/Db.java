package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Util.DBConnection;


@WebServlet("/Db")
public class Db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Db() {
        super();
            }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		try {
			Connection con = DBConnection.GetConnection();
			out.print(con);
		} catch (Exception ex) {
			ex.printStackTrace();
			out.print(ex);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
