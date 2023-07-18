package com.jdbcdemo.myApp;
import java.util.*;
import java.sql.*;
public class App 
{
    public static void main( String[] args )
    {
    	int id,esal;
    	String ename;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("enter emplyoee number:");
    	id=sc.nextInt();
    	System.out.println("enter emplyoee name:");
    	ename=sc.next();
    	System.out.println("enter emplyoee salary:");
    	esal=sc.nextInt();
        //1.Loading the databse driver
    	try
    	{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//2 establish the connection
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vasu_database","root","root");
    	
    	//3.prepared statement
    	PreparedStatement pstmt = con.prepareStatement("INSERT INTO employee VALUES(?,?,?)");
    	pstmt.setInt(1, id);
    	pstmt.setString(2, ename);
    	pstmt.setInt(3, esal);
    	 int i = pstmt.executeUpdate();
    	if(i==1) {
    		System.out.println("connected to database");
    	}else {
    		System.out.println("connection fails");
    	}
    	con.close();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
}
