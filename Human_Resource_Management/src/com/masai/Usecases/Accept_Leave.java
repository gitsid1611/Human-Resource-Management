package com.masai.Usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.Bean.Department;
import com.masai.Bean.Leaves;
import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.DepartmentException;
import com.masai.Exceptions.EmployeeException;

public class Accept_Leave {

	public static void leav() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Employee -ID");
		int empID =  sc.nextInt();
		
       AdminDao dao = new AdminDaoImpl() ;
		
//		String result = edao.acceptLeave(empID) ;
//		System.out.println(result);
		
//		//////////////////////////////////////////////////////////
		
		try {
			List<Leaves> dep = dao.getLeavesList();
			dep.forEach(res -> System.out.println(res));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}

