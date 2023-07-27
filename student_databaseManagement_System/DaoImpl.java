package com.Bitlabs.Student_database_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.Bitlabs.EmpDatabase.DaoInterface;
import com.Bitlabs.EmpDatabase.Student;
public class DaoImpl implements DaoInterface
{
 
	
	Scanner sc=new Scanner(System.in);
	Student student=new Student();
	public void insert() {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vasu_database","root","root");
			if(con!=null) {
				System.out.println("connetion made successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter student id");
		int id=sc.nextInt();
		student.setId(id);
		System.out.println("Enter student name");
		String name=sc.next();
		student.setName(name);
		System.out.println("Enter student branch");
		String branch=sc.next();
		student.setBranch(branch);
		//create statement
		try {
			Statement st=con.createStatement();
			
			//execute statement
			int i=st.executeUpdate("insert into student1 values('"+student.getId()+"','"+student.getName()+"','"+student.getBranch()+"')");
			
			if(i!=0) {
				System.out.println("Data inserted successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update() {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vasu_database","root","root");
			if(con!=null) {
				System.out.println("connetion made successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter student id to update");
		int id=sc.nextInt();
		student.setId(id);
		System.out.println("Enter student name to update");
		String name=sc.next();
		student.setName(name);
		
		//create statement
		try {
			Statement st=con.createStatement();
			
			//execute statement
			int i=st.executeUpdate("update student1 set name='"+student.getName()+"' where id='"+student.getId()+"'");
			
			if(i!=0) {
				System.out.println("Data updated successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void delete() {
		
				Connection con=null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vasu_database","root","root");
					if(con!=null) {
						System.out.println("connetion made successfully");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Enter student id to delete");
				int id=sc.nextInt();
				student.setId(id);
				
				
				//create statement
				try {
					Statement st=con.createStatement();
					
					//execute statement
					int i=st.executeUpdate("delete from student1 where id='"+student.getId()+"'");
					
					if(i!=0) {
						System.out.println("Data deleted successfully");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
	}
	public void getAll() {
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vasu_database","root","root");
			if(con!=null) {
				System.out.println("connetion made successfully");
			}
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student1");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	

}

