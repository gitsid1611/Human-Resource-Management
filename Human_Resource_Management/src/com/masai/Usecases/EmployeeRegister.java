package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Bean.Employee;
import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class EmployeeRegister {

	public static void employeeRegister() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Username for Employee");
		String username = sc.nextLine();
		
		System.out.println("Enter the password for Employee");
		String password = sc.nextLine();
		
		System.out.println("Enter the Name of Employee");
		String name = sc.nextLine();
		
		System.out.println("Assign the Department-ID to Employee");
		int deptId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter the Salary of the Employee");
		int Salary =sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter the Joining-Date of Employee");
		String Date = sc.nextLine();
		
		
		System.out.println("Enter Leave");
		int leave = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the Manager-Id");
		int manage= sc.nextInt();
		sc.nextLine();
		
		
		Employee e1 = new Employee();
		e1.setUsername(username);
		e1.setPassword(password);
		e1.setName(name);
		e1.setDeptId(deptId);
		e1.setSalary(Salary);
		e1.setJoinDate(Date);
		e1.setLeaveAvi(leave);
		e1.setManageID(manage);
		
		AdminDao dao = new AdminDaoImpl();
		
		String result = dao.ragisterEmployee(e1);
		
		if (result.equals("Employee Register Successfully Username and password has been send to employee")) {
			System.out.println(result);
		}
		else {
			System.out.println(result);
		}
		
	}
}
