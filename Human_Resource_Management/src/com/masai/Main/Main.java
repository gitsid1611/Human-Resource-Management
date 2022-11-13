package com.masai.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Usecases.Accept_Leave;
import com.masai.Usecases.AddDepartment;
import com.masai.Usecases.AdminLoginUseCase;
import com.masai.Usecases.Apply_Leave;
import com.masai.Usecases.EmployeeLoginUseCase;
import com.masai.Usecases.EmployeeRegister;
import com.masai.Usecases.Get_List_Leaves;
import com.masai.Usecases.Reject_Leave;
import com.masai.Usecases.TransferEmployee;
import com.masai.Usecases.UpdateDepartment;
import com.masai.Usecases.Update_Password;
import com.masai.Usecases.ViewDepartment;
import com.masai.Usecases.ViewPersonal_Profile;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		
		AdminOrEmployee();
		
		
	}
	
	//////////////////////////Welcome ///////////////////////
	
	static void AdminOrEmployee() {
		System.out.println("Welcome to Human Resource Management" +"\n"
	                        +"Choose the following option to Login!..."+"\n");
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
		
		
			choice = sc.nextInt();
//			sc.close();
		
		
		if(choice ==1)
		{
			System.out.println("Choose the following option"+"\n");
			AdminLogin();
		}
		else if(choice==2)
		{
			if(EmployeeLoginUseCase.login()==true)
			{
				System.out.println("\n"+"Login Successful .. Please choose following operation ."+"\n");
				employeeMethods();
			}
			else {
				System.out.println("Wrong Credentials Please Choose Right option.");
				AdminOrEmployee();
			}
			
		}
		else if(choice ==3){
			AdminOrEmployee();
		}
		else {
			System.out.println("Please Select Correct Option.");
			AdminOrEmployee();
		}
	}
	
	
	
	//////////////////////////// Welcome & option-end //////////////////
	
	
	
	
	//////////////////////////// admin login + feature ///////////////
	
	static void AdminLogin() {
		
		Boolean result = AdminLoginUseCase.login();

		if (result) adminMethods();
		else {
			AdminLogin();
		}
	}
	
//	////////////////////////////// login -end //////////////
	
	//////////////////////// admin-options  ///////////
	
	static void adminMethods() {
		System.out.println( "+-------------------------------------------- +" + "\n"
							 + "| Welcome Admin                            |" + "\n"
							 + "| 1. Add Department                        |" + "\n"
							 + "| 2. Update Department Location            |" + "\n"
							 + "| 3. Register Employee                     |" + "\n"
							 + "| 4. Transfer Employe                      |" + "\n"
							 + "| 5. View Department                       |" + "\n"
							 + "| 6. Accept Leave Application              |" + "\n"
							 + "| 7. Reject Leave Application              |" + "\n"
							 + "| 8. Logout                                |" + "\n"
							 + "+----------------------------------------- +");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
	
		try {
			choice = sc.nextInt();
		
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice!=6 && choice!=7 && choice !=8) {
				System.out.println("Please Select Correct Option.");
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
				System.out.println("\n");
				AddDepartment.addDepartment();
				System.out.println("\n"+"Please Select Following Option"+"\n");
				adminMethods();
			}
			break;
			case 2 : {
				System.out.println("\n");
				UpdateDepartment.updateDept();
				System.out.println("\n"+"Please Select Following Option"+"\n");
				adminMethods();
			}
			break;
			case 3 : {
				System.out.println("\n");
				EmployeeRegister.employeeRegister();
				System.out.println("\n"+"Please Select Following Option"+"\n");
				adminMethods();
			}
			break;
			case 4 : {
				System.out.println("\n");
				TransferEmployee.transfe();
				System.out.println("\n"+"Please Select Following Option"+"\n");
				adminMethods();
			}
			break;	
			case 5 : {
				System.out.println("\n");
				ViewDepartment.viewDept();
				System.out.println("\n"+"Please Select Following Option"+"\n");
				adminMethods();
			}
			break;	
			case 6 : {
				System.out.println("\n");
				Get_List_Leaves.leav();
				System.out.println("\n"+"Please Select Following Option"+"\n");
				Accept_Leave.leav();
				System.out.println("\n"+"Please Select Following Option"+"\n");
				adminMethods();
			}
			break;	
			case 7 : {
				System.out.println("\n");
				Get_List_Leaves.leav();
				System.out.println("Please Select Following Option"+"\n");
				Reject_Leave.leav();
				System.out.println("Please Select Following Option"+"\n");
				adminMethods();
			}
			break;
			case 8 : 
				AdminOrEmployee();
		}
}
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////
//	                             Employee Dashboard
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	static void employeeMethods() {
		
		System.out.println("\n"+"+--------------------------------+" + "\n"
				 		 + "| 1. View Profile                |" + "\n"
				         + "| 2. Update Profile Password     |" + "\n"
				         + "| 3. Request for Leave           |" + "\n"
				         + "| 4. Logout                      |" + "\n"
				         + "+--------------------------------+");
		
		
		
		try {
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			if (choice == 1) {
				System.out.println("\n");
				ViewPersonal_Profile.vieprofil();
				System.out.println("Please Select Following Option"+"\n");
				employeeMethods();
			}
			else if (choice == 2) {
				System.out.println("\n");
				Update_Password.pass();
				System.out.println("Please Select Following Option"+"\n");
				employeeMethods();
			}
			else if (choice == 3) {
				System.out.println("\n");
				Apply_Leave.appl();
				System.out.println("Please Select Following Option"+"\n");
				employeeMethods();
			}
			else if (choice == 4) {
				AdminOrEmployee();
			}
			else {
				System.out.println("Please Choose Correct Option");
				employeeMethods();
			}
		}
		catch (InputMismatchException e) {
			AdminOrEmployee();
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
