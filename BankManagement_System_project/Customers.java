package com.jdbcdemo.myApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customers extends BankingFun {

	 Scanner sc = new Scanner(System.in);
		public void insertData(Connection con)
		{
			
			System.out.println("this is inserting customers data into the customers");
			int i;
			System.out.println("enter customer details like customerid , firstname , lastname , address and contactNumber");
			int customerId = sc.nextInt();
			String firstname = sc.next();
			String lastname = sc.next();
			String address = sc.next();
			long contactNumber = sc.nextLong();
			try {
				Statement st = con.createStatement();
				PreparedStatement pstm =con.prepareStatement("insert into customers values(?,?,?,?,?)");
				pstm.setInt(1, customerId);
				pstm.setString(2, firstname);
				pstm.setString(3, lastname);
				pstm.setString(4, address);
				pstm.setLong(5, contactNumber);
				i = pstm.executeUpdate();
				if(i != 0) {
					System.out.println("data inserted successfully!.into customers table");
				}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
		public void readData(Connection con)
		{
			System.out.println("this is display section of the customers");
			try
			{
			    Statement st = con.createStatement();
			    ResultSet rs = st.executeQuery("select * from customers ");
			    while(rs.next()) {
			    	System.out.print(rs.getInt(1) + " " + rs.getString(2) +" "+ rs.getString(3) +" "+ rs.getString(4)+" "+rs.getLong(5));
			    }
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
		public void updateData(Connection con)
		{
			
			System.out.println("this is update section of the customers");
			System.out.println("enter customerid");
			int customerId = sc.nextInt();
			System.out.println("enter new firstname and lastname:");
			String firstname = sc.next();
			//String lastname = sc.next();
			try
			{
				Statement st = con.createStatement();
				int i = st.executeUpdate("update customers set firstname = '"+firstname+" ' WHERE customerId ='"+customerId+"'");
				if(i != 0) {
					System.out.println("updated succesfullyyy");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
			System.out.println();
		}
		public void deleteData(Connection con)
		{
			
			System.out.println("this is the deleted section");
			System.out.println("enter customerid:");
			int customerId = sc.nextInt();
			try
			{
				Statement st = con.createStatement();
				int i = executeUpdate("delete from customers where customerid = '"+customerId+"'");
				if(i != 0) {
					System.out.println("deleted successfully");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
		public int executeUpdate(String string) {
			// TODO Auto-generated method stub
			return 0;
		}
		
}
