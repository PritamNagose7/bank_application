package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con = null;
	final static String driver = "com.mysql.cj.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost/bank";
	static final String Username = "root";
	static final String Password = "root";

	public static Connection GetConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, Username, Password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

}
