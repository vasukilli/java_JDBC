package com.jdbcdemo.myApp;
import java.util.*;
import java.sql.*;
public class Student 
{
  public static void main(String[] args)
  {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("enter student details like sid,sname,svillage,scollege");
	  int sid = sc.nextInt();
	  sc.nextLine();
	  String sname = sc.nextLine();
	  int sage = sc.nextInt();
	  sc.nextLine();
	  String svillage = sc.nextLine();
	  String scollege = sc.nextLine();
	  try {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vasu_database","root","root");
	  PreparedStatement pstmt = con.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?)");
	  pstmt.setInt(1, sid);
	  pstmt.setString(2,sname);
	  pstmt.setInt(3,sage);
	  pstmt.setString(4,svillage);
	  pstmt.setString(5, scollege);
	  int i =pstmt.executeUpdate();
	  if(i==1) {
		  System.out.println("connected to data base");
	  }else {
		  System.out.println("connection is failed");
	  }
      con.close();
      }
	  catch(Exception e) {
		  System.out.println(e);
	  }
}
}
