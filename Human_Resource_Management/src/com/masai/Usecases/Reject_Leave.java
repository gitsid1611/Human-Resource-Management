package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class Reject_Leave {

	public static void leav() {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Please Enter the Employee-Id for deleting Leave Application");
		int empId = sc.nextInt();
		
		AdminDao dao = new AdminDaoImpl();
		String result = dao.rejectLeave(empId);
		System.out.println(result);
		
		
		
		
	}
}
