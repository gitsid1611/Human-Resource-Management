package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class Accept_Leave {

	public static void leav() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Employee -ID");
		int empID =  sc.nextInt();
		
       AdminDao edao = new AdminDaoImpl() ;
		
		String result = edao.acceptLeave(empID) ;
		System.out.println(result);
	}
	}

