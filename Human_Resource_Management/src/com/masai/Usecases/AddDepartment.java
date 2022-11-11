package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Bean.Department;
import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.DepartmentException;

public class AddDepartment {
	
	public static void addDepartment() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Department Name");
		String name = sc.nextLine();
//		sc.nextLine();

		System.out.println("Enter Department Location");
		String location = sc.nextLine();
		sc.close();
		
		
		Department d1 = new Department();
		d1.setDeptName(name);
		d1.setDeptLoc(location);
		
		
		AdminDao dao = new AdminDaoImpl();
		
		
			String result =dao.addDepartment(d1);
//			System.out.println(result);
			if (result.equals("Bus added Successfully")) {
				System.out.println(result);
			}
			else {
				System.out.println(result);
			}
			
		
		
		
	}

}
