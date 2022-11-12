package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class TransferEmployee {

	public static void transfe() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Department=ID");
		int dept = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the Employee-ID for transfer.");
		int emp =sc.nextInt();
		
		AdminDao dao = new AdminDaoImpl();
		
		String result = dao.transferEmployee(emp, dept);
		
		if (result.equals("Employee Transfered to other Department is successful.")) {
			System.out.println(result);
		}
		else {
			System.out.println(result);
		}
	}
}
