package com.masai.Usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.Bean.EmployeeDto;
import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.Exceptions.EmployeeException;

public class ViewPersonal_Profile {

	public static void vieprofil() {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter your Employee-Id to view your Details:");
		int empId= sc.nextInt();

		
		EmployeeDao cdao= new EmployeeDaoImpl();
		
		try {
		List<EmployeeDto> dtos= cdao.getProfiledata(empId);
		
		dtos.forEach(dto -> System.out.println(dto));
		
		
		
		}catch(EmployeeException c) {
			System.out.println(c.getMessage());
		}
	}
}
