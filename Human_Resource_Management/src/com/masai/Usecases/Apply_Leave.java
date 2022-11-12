package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;

public class Apply_Leave {

	public static void appl() {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Your Employee-ID");
		int empId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter numbers days for Leave.");
		int leave = sc.nextInt();
//		sc.close();
		
		sc.nextLine();
		
		System.out.println("Enter the Reason for Leave");
		String reson = sc.nextLine();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		String result=dao.applyForLeave(empId, leave, reson);
		if (result.equals("You have applied for leave wait for admin to take action")) {
			System.out.println(result);
		}
		else {
			System.out.println(result);
		}
	}
	
}
