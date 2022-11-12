package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class AdminLoginUseCase {

	public static boolean login() {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the username...");
		String username =sc.nextLine();
		
		
		System.out.println("Enter the password..");
		String password =sc.nextLine();
		
//		sc.close();
		
		AdminDao dao = new AdminDaoImpl();
		String result =  dao.adminLogin(username, password);
		
		if (result.equals("Login Successfully !")){
			System.out.println(result);
			return true;
		}
		else {
			System.out.println(result);
			return false;
		}
		
		
		

		
		
		
		
		
	}
}
