package com.jdbcdemo.myApp;
import java.util.*;
import java.sql.*;
public class EmployeeDtabase 
{
 
	public static void main(String[] args) throws ClassNotFoundException 
	{
		 Scanner sc = new Scanner(System.in);
		 int option;
		 Connection con = null;
		 emp1 e1 = new emp1();
		 
		 try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vasu_database","root","root");
			
		 }catch(SQLException e){
			 e.printStackTrace();
		 }

		do {
		 
		 System.out.println("1.insert the data into the database");
		 System.out.println("2.display the details from the database");
	
		 System.out.println("3.update the database by using name");
		 System.out.println("4.delete the data by using id");
		 System.out.println("5.update the mail by using name");
		 System.out.println("enter options from 1 to 5");
		 System.out.println("you need to exit from this ,then enter 0");
		 System.out.println("enter option:");
		  option = sc.nextInt();
		 switch(option)
		 {
		 case 1 : e1.insertData(con);
		 break;
		 
		 case 2 : e1.getAll(con);
		 break;
		  
		 case 3 : e1.updateName(con);
		 break;
		 
		 case 4 : e1.deleteById(con);
		 break;
		 
		 case 5 : e1.updateByMail(con);
		 break;
		 }
		 }while(option != 0);
	}
		 
}
class emp1 extends EmployeeDtabase
{
	static Scanner sc = new Scanner(System.in);
	public void insertData(Connection con)
	{
		System.out.println("enter student details like id,name,age,mail,phonum and village:");
		int id = sc.nextInt();
		String name = sc.next();
		int age = sc.nextInt();
		String mail = sc.next();
		long phonum = sc.nextLong();
		String village = sc.next();
		try
		{
		PreparedStatement pst = con.prepareStatement("Insert into study values (?,?,?,?,?,?)");
		pst.setInt(1, age);
		pst.setString(2, village);
		pst.setInt(3, age);
		pst.setString(4, mail);
		pst.setLong(5, phonum);
		pst.setString(6,village);
		
		int i=pst.executeUpdate();//connected to database it gives 1..
		if(i != 0) {
			System.out.println("successfully stored the values in the database");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void getAll(Connection con)
	{
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from study");
			while(rs.next()) {
				System.out.println(rs.getInt(1) +" "+ rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5)+" "+rs.getString(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateName(Connection con)
	{
	   System.out.println("enter id");
	   int id = sc.nextInt();
	   System.out.println("enter new name");
	   String name = sc.next();
	   try
	   {
		 Statement st = con.createStatement();
		 int i= st.executeUpdate("update study set name='"+name+"' where id='"+id+"'");
		 if(i != 0) {
			 System.out.println("update successfully");
		 }
		 
	   }catch(SQLException e) {
		  e.printStackTrace();
	   }
	   
	   
	}
	public void deleteById(Connection con)
	{
		System.out.println("enter student id");
		int id = sc.nextInt();
		try
		{
			Statement st = con.createStatement();
			int i=st.executeUpdate("delete from employee1 where id='"+id+"'");
			if(i != 0) {
			System.out.println("deleted successfully");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateByMail(Connection con)
	{
		System.out.println("enter id :");
		int id = sc.nextInt();
		System.out.println("enter new mail id:");
		String mail = sc.next();
		try
		{
			Statement st = con.createStatement();
			int i =st.executeUpdate("update employee1 set mail='"+mail+"' where id='"+id+"'");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
		 
	