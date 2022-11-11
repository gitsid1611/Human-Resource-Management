package com.masai.Dao;

import com.masai.Bean.Department;
import com.masai.Exceptions.DepartmentException;

public interface AdminDao {
	
	public final String username ="Admin";
    public final String password ="1234";
    
    public String adminLogin(String username,String password);
    
    public abstract String addDepartment(Department department);
    
    public abstract String updateDepartmentLocation(String deptName , String location) ;

}
