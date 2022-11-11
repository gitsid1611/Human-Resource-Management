package com.masai.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.Usecases.AddDepartment;
import com.masai.Usecases.AdminLoginUseCase;
import com.masai.Usecases.UpdateDepartment;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		
		AdminOrEmployee();
		
		
	}
	
	//////////////////////////Welcome ///////////////////////
	
	static void AdminOrEmployee() {
		System.out.println("+---------------------------+" + "\n"
						    + "| 1. Login As Administrator |" + "\n"
						 	+ "| 2. Login As Employee      |" + "\n"
						 	+ "| 3. Exit                   |" + "\n"
						 	+ "+---------------------------+");
		choice();
	}
	
	
	static void choice() {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
		try {
			choice = sc.nextInt();
		}
		catch (InputMismatchException e) {
			
			AdminOrEmployee();
		}
		
		if(choice ==1)
		{
			AdminLogin();
		}
		else if(choice==2)
		{
			System.out.println("Employee login");
		}
		else if(choice==3)
		{
			System.exit(0);
		}
		else {
			AdminOrEmployee();
		}
	}
	
	
	
	//////////////////////////// Welcome & option-end //////////////////
	
	
	
	
	//////////////////////////// admin login + feature ///////////////
	
	static void AdminLogin() {
		Boolean result = AdminLoginUseCase.login();
		
		if(result)
		{
			adminMethods();
		}
		else {
			AdminLogin();
		}
	}
	
//	////////////////////////////// login -end //////////////
	
	//////////////////////// admin-options  ///////////
	
	static void adminMethods() {
		System.out.println("+--------------------------------+" + "\n"
							 + "| Welcome Admin                  |" + "\n"
							 + "| 1. Add Bus                     |" + "\n"
							 + "| 2. Confirm Tickets of Customer |" + "\n"
//							 + "| 3. View All Bookings           |" + "\n"
//							 + "| 4. Back                        |" + "\n"
							 + "| 5. Exit                        |" + "\n"
							 + "+--------------------------------+");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
	
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				adminMethods();
			}
			else adminChoice(choice);
		}
		catch (InputMismatchException e) {
			
			adminMethods();
		}
	}
	
	
	////////////////////////////  admin -options end //////////////////////////////////
	
	
	////////////////////////////admin -feature ///////////////////////////////////////
	
	
	
	static void adminChoice(int choice) {
		
		switch(choice) {
			case 1 : {
				AddDepartment.addDepartment();
				adminMethods();
			}
			break;
			case 2 : {
				UpdateDepartment.updateDept();
				adminMethods();
			}
			break;
//			case 3 : {
//				ViewAllTicketsusecase.viewAllTicket();
//				adminMethods();
//			}
//			break;
//			case 4 : AdminOrEmployee();
//			break;	
			case 5 : {
				System.exit(0);
			}
		}
}

}
