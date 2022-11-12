package com.masai.Usecases;

import java.util.List;

import com.masai.Bean.Leaves;
import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.EmployeeException;

public class Get_List_Leaves {

	public static void leav() {
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			List<Leaves> list = dao.getLeavesList() ;
			System.out.println(list);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
