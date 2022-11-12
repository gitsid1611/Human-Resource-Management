package com.masai.Dao;

import java.util.List;

import com.masai.Bean.EmployeeDto;
import com.masai.Exceptions.EmployeeException;

public interface EmployeeDao {

	public String loginEmployee(String username, String password) throws EmployeeException;
	
	public List<EmployeeDto> getProfiledata(int empId)throws EmployeeException;
	
	public abstract String applyForLeave(int empId , int day , String resaon);
	
	public abstract String updatePassword(int empId , String password) ;
	
}
