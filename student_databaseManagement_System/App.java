package com.Bitlabs.EmpDatabase;
//import com.Bitlabs.impl.*;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DaoImpl dao=new DaoImpl();
		int option=0;
		do {
			System.out.println("Enter 1 to get All students");
			System.out.println("Enter 2 to add student");
			System.out.println("Enter 3 to update student");
			System.out.println("Enter 4 to delete student by id");
			System.out.println("Enter 0 to exit");
			System.out.println("Enter a choice");
			option=sc.nextInt();
			
			switch(option) {
			case 1:
				dao.getAll();
				break;
			case 2:
				dao.insert();
				break;
			case 3:
				dao.update();
				break;
			case 4:
				dao.delete();
				break;
			}
		}while(option!=0);
		
		
		
		
	}
}

