package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;

public class Update_Password {

	public static void pass() {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Employee-Id");
		int empId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the new-Password");
		String password = sc.nextLine();
//		sc.close();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		String result=dao.updatePassword(empId, password);
		if (result.equals("Password changed successfully")) {
			System.out.println(result);
		}
		else {
			System.out.println(result);
		}
	}
}
