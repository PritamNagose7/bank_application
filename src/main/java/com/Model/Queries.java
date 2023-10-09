package com.Model;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import com.Util.DBConnection;

public class Queries {

	
	// query insert update delete 
	public static int update(Account a) {
		int status = 0;
		 try {
			 Connection con = DBConnection.GetConnection();
			 PreparedStatement ps  = con.prepareStatement("update account set balance=? where accountnumber=?");
			 ps.setInt(1, a.getBalance());
			 ps.setString(2, a.getAccountnumber());
			 
			 status = ps.executeUpdate();
			 con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		 return status;
	}
	
	
	
	
	
	// query for search
	 public static Account getBalanceByaccountnumber(String accountnumber)
	 {
		 Account acn = new Account();
		 
		 try {
			 Connection con = DBConnection.GetConnection();
			 PreparedStatement ps = con.prepareStatement("select * from account where accountnumber=?");
			 ps.setString(1, accountnumber);
			 ResultSet rs = ps.executeQuery();
			 
			 if (rs.next()) {
				 
				 acn.setAccountnumber(rs.getString(2));
				 acn.setBalance(rs.getInt(5));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		 
		return acn;
	 }
	
	
	 // registration part
	public static int save(Emp e)   // method for save
	{
		int status = 0;
		try {
			Connection con = DBConnection.GetConnection();   // database talk
			String sql = "insert into regi(first_name,last_name,email_address,mobile_no,aadhar_no,address) values (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, e.getFirst_name());
			pst.setString(2, e.getLast_name());
			pst.setString(3, e.getEmail_address());
			pst.setDouble(4, e.getMobile_no());
			pst.setDouble(5, e.getAadhar_no());
			pst.setString(6, e.getAddress());
			status = pst.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();   // error track
			
			System.out.println("ex");  //show the error
		}
		
		
		return status;
	}
	
	
	
	 // Generate Account part
	public static int save(Account a)   // method for save
	{
		int status = 0;
		try {
			Connection con = DBConnection.GetConnection();   // database talk
			String sql = "insert into account(name,accountnumber,account_no,password) values (?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, a.getName());
			pstm.setString(2, a.getAccountnumber());
			pstm.setString(3, a.getAccount_no());
			pstm.setString(4, a.getPassword());
			status = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();   // error track
			
			System.out.println("thre is an exceptions");  //show the error
		}
		
		return status;
	}

}
