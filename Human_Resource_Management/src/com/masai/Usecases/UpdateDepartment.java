package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class UpdateDepartment {

	public static void updateDept() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter new Location for Updatation");
		String Location = sc.nextLine();
		
		System.out.println("Enter the Department Name whose Location is to be change");
		String name = sc.nextLine();
		sc.close();
		
		AdminDao dao = new AdminDaoImpl();
		String result=dao.updateDepartmentLocation(name, Location);
		System.out.println(result);
	}
}
