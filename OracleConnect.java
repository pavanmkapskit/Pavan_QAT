package com.ntt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnect {
	public static void main(String args[])
	{
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("aayth hogo appi");
			Connection con=DriverManager.getConnection(url,"jdbc","jdbc");
			System.out.println("Connection Established");
			//coding part do it over here
			Statement stmt=con.createStatement();
			String updateQuery="UPDATE EMPLOYEE1 SET EMPFNAME='MUNNA' WHERE EMPID=3";
			stmt.executeUpdate(updateQuery);
			ResultSet rs=stmt.executeQuery("Select * from employee1");
			System.out.println("query execution"+rs);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
			}
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		catch(SQLException e)
		{
			System.out.println("connection aglila");
		}
	}

}
