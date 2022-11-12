package com.masai.Usecases;

import java.util.List;

import com.masai.Bean.Department;
import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.DepartmentException;

public class ViewDepartment {

	public static void viewDept() {
		
		AdminDao dao =new AdminDaoImpl();
		
	
		try {
			List<Department> dep = dao.viewDepartment();
			dep.forEach(res -> System.out.println(res));
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
