package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.masai.Bean.Department;
import com.masai.Exceptions.DepartmentException;

import com.masai.Utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	



//	for Admin Login
	
	@Override
	public String adminLogin(String username, String password) {
		String message = "Invalid username or password";
		
		if(username.equals(AdminDao.username) && password.equals(AdminDao.password))
		{
			message ="Login Successfully !";
		}
		
		
		
		return message;
	}
	

//	add department by admin.
	
	@Override
	public String addDepartment(Department department) {
		
		String result = "Department Not Added" ;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			String query = "insert into department(deptName , deptLoc) values(?,?)" ;
			
			PreparedStatement ps = conn.prepareStatement(query) ;
			
			ps.setString(1, department.getDeptName());
			ps.setString(2, department.getDeptLoc());
			
			int x = ps.executeUpdate() ;
			
			if(x>0) {
				result = "Department Added successfully" ;
			}
			
		} 
		catch (SQLException e) {
			result = e.getMessage();
		}
		
		return result;
	}


@Override
public String updateDepartmentLocation(String deptName , String location) {


	String result = "Not update" ;
	
	try(Connection conn = DBUtil.provideConnection()) {
		
		String query = "update department set deptLoc = ? where deptName = ?" ;
		PreparedStatement ps =conn.prepareStatement(query) ;
		ps.setString(1, location);
		ps.setString(2, deptName);
		int x = ps.executeUpdate() ;
		if(x>0) {
			result = "Department Update Successfully" ;
		}
		
	} catch (SQLException e) {
			result = e.getMessage() ;
	}
	
	
	
	
	
	
	return result ;
}
	
	
	
	
	
	

}
