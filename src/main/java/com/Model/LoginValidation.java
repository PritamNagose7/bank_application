package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Util.DBConnection;

public class LoginValidation {

	public static boolean Validation(String account_no, String password) // method
	{
		boolean flag = false;

		try {
			Connection con = DBConnection.GetConnection(); // connection
			String sql = "select * from account where account_no=? and password=?"; // query
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, account_no);
			pst.setString(2, password);
			ResultSet rst = pst.executeQuery();
			flag = rst.next();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return flag;
	}
}
