package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class AdminLoginUseCase {

	public static boolean login() {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the username...");
		String username =sc.next();
		
		
		System.out.println("Enter the password..");
		String password =sc.next();
		
		sc.close();
		
		AdminDao dao = new AdminDaoImpl();
		String result =  dao.adminLogin(username, password);
		
		if (result.equals("Login Successfully !")){
			
			return true;
		}
		else {
			return false;
		}
		
		
		

		
		
		
		
		
	}
}
