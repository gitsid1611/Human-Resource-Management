package com.masai.Dao;

import java.util.List;

import com.masai.Bean.Department;
import com.masai.Bean.Employee;
import com.masai.Bean.Leaves;
import com.masai.Exceptions.DepartmentException;
import com.masai.Exceptions.EmployeeException;


public interface AdminDao {
	
	public final String username ="Admin";
    public final String password ="1234";
    
    public String adminLogin(String username,String password);
    
    public abstract String addDepartment(Department department);
    
    public abstract String updateDepartmentLocation(String deptName , String location) ;
    
    public abstract String ragisterEmployee(Employee employee);
    
    public String transferEmployee(int empId , int deptId);
    
    public List<Department> viewDepartment() throws DepartmentException;
    
    public List<Leaves> getLeavesList() throws EmployeeException ;
    
    public String acceptLeave(int empId) ;
    
	public String rejectLeave(int empId) ;
    
    

}
