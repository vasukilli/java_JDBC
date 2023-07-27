package com.jdbcdemo.myApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Transactions extends BankingFun 
{

	 Scanner sc = new Scanner(System.in);
	public void insertData(Connection con)
	{
		System.out.println("insert data into the transaction table session");
		System.out.println("enter transaction details like transactionId , accountId ,transactionType ,amount,transactionDate");
		int transactionId = sc.nextInt();
		int accountId = sc.nextInt();
		String transactionType = sc.next();
		int amount = sc.nextInt();
		String transactionDate = sc.next();
		try
		{
			PreparedStatement pstm = con.prepareStatement("insert into transactions values(?,?,?,?,?)");
			pstm.setInt(1,transactionId);
			pstm.setInt(2, accountId);
			pstm.setString(3,transactionType);
			pstm.setInt(4, amount);
			pstm.setString(5, transactionDate);
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
		System.out.println("read data from transactions table:");
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from transactions");
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
		System.out.println("this is the update section for transactions ");
		System.out.println("enter accountid:");
		int accountId = sc.nextInt();
		System.out.println("enter new balance");
		int amount = sc.nextInt();
		try
		{
			Statement stm = con.createStatement();
			int i = stm.executeUpdate("update transactions set amount = '"+amount+" ' WHERE accountId ='"+accountId+"'");
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
		System.out.println("this is the delete section for transactions");
		System.out.println("enter accountid:");
		int accountId = sc.nextInt();
		try
		{
			Statement stm = con.createStatement();
			int i = executeUpdate("delete from transactions where accountId = '"+accountId+"'");
			if(i != 0) {
			System.out.println("deleted succesfully...");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
	}
	private int executeUpdate(String string) {
		// TODO Auto-generated method stub
		return 0;
	}



	

}
