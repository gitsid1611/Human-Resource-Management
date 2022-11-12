package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Bean.EmployeeDto;
import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.Exceptions.EmployeeException;

public class EmployeeLoginUseCase {

	public static boolean login() {
		boolean res = false;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username..");
		String username = sc.next();
		System.out.println("Enter password..");
		String password = sc.next();
		
		try {
			EmployeeDao ad = new EmployeeDaoImpl();
			ad.loginEmployee(username, password);
			res = true;

		} catch (EmployeeException e) {

			System.out.println(e.getMessage());
		}

		return res;
		
	}
}
