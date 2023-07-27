package com.jdbcdemo.myApp;
import java.util.*;

import java.sql.*;
public class BankManagementSystem 
{

	public static void main(String[] args) throws ClassNotFoundException 
	{
		Scanner sc = new Scanner(System.in);
		int option;
		Connection con = null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","root");
	}catch(SQLException e) {
		e.printStackTrace();
	}
	 if(con!=null) {
		 System.out.println("successfully connected to database");
	 }
	 Customers c = new Customers();
	Accounts a = new Accounts();
	Transactions t = new Transactions();
	
	 
	 System.out.println("........Welcome to Bank Management System.....");
	 System.out.println("1.Customers section.");
	 System.out.println("2.accounts section.");
	 System.out.println("3.Transactions section.");
	 System.out.println("enter any option from 1 to 3");
	 System.out.println("if you want exit from this then enter 0");
	  do
	  {
		  option = sc.nextInt();
		  switch(option) {
		
		  case 1 :
			       c.insertData(con);
			       
		           c.readData(con);
		          
		           c.updateData(con);
		          
		           c.deleteData(con);
		           
		  break;
		 // Accounts a = new Accounts();
		  case 2 : a.insertData(con);
		           a.readData(con);
                   a.updateData(con);
                   a.deleteData(con);
          break;
          //Transactions t = new Transactions();
		  case 3 : t.insertData(con);
                   t.readData(con);
                   t.updateData(con);
                   t.deleteData(con);
           break;
		  }
		  
	  }while(option != 0);
	 
	}
}
