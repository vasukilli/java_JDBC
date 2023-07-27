package com.jdbcdemo.myApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Accounts extends BankingFun
{

	Scanner sc = new Scanner(System.in);
	public void insertData(Connection con)
	{
		 
		System.out.println("insert data into the accounts table session");
		System.out.println("enter accounts details like accountid , customerid ,accounttype ,balance,opendate");
		int accountId = sc.nextInt();
		int customerId = sc.nextInt();
		String accountType = sc.next();
		int balance = sc.nextInt();
		String openDate = sc.next();
		try
		{
			PreparedStatement pstm = con.prepareStatement("insert into emailaccounts values(?,?,?,?,?)");
			pstm.setInt(1,accountId);
			pstm.setInt(2, customerId);
			pstm.setString(3,accountType);
			pstm.setInt(4, balance);
			pstm.setString(5, openDate);
			int i = pstm.executeUpdate();
			if(i != 0) {
				System.out.println("data inserted successfully!..");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	public void readData(Connection con)
	{
		System.out.println("read data from emailaccounts table:");
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emailaccounts");
			while(rs.next()) {
				System.out.print(rs.getInt(1) +" "+ rs.getInt(2) +" "+ rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	public void updateData(Connection con)
	{
		
		System.out.println("this is the update section for email accounts");
		System.out.println("enter accountid:");
		int accountId = sc.nextInt();
		System.out.println("enter new balance");
		int balance = sc.nextInt();
		try
		{
			Statement stm = con.createStatement();
			int i = stm.executeUpdate("update emailaccounts set balance = '"+balance+" ' WHERE accountId ='"+accountId+"'");
			if(i != 0) {
			System.out.println("updated succesfull");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	public void deleteData(Connection con)
	{
	   
		System.out.println("this is the delete section for email accounts");
		System.out.println("enter accountid:");
		int accountId = sc.nextInt();
		try
		{
			Statement stm = con.createStatement();
			int i = executeUpdate("delete from emailaccounts where accountId = '"+accountId+"'");
			if(i != 0) {
			System.out.println("deleted succesfully...");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();}
		}

	public int executeUpdate(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

}
