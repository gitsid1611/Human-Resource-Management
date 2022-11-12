package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Department;
import com.masai.Bean.Employee;
import com.masai.Bean.Leaves;
import com.masai.Exceptions.DepartmentException;
import com.masai.Exceptions.EmployeeException;
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

	
	//////////////////////////// Update -department location by deptname //////////////////////

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
			result = "Department Updated Successfully" ;
		}
		
	} catch (SQLException e) {
			result = e.getMessage() ;
	}
	
	
	
	
	
	
	return result ;
}


////////////////////////////// admin register new employee //////////////////////////////


@Override
public String ragisterEmployee(Employee employee) {
	String result = "Not Added" ;
	
	 try(Connection conn = DBUtil.provideConnection()) {
		 String query = "insert into employee(username,password,name,deptId,Salary,joinDate,leaveAvi,ManageID) "+
				 		"values(? , ? , ? , ? , ? , ? , ? , ?)";
		 
		 
		 PreparedStatement ps = conn.prepareStatement(query) ;
		 ps.setString(1, employee.getUsername());
		 ps.setString(2, employee.getPassword());
		 ps.setString(3, employee.getName());
		 ps.setInt(4, employee.getDeptId());
		 ps.setInt(5, employee.getSalary());
		 ps.setString(6, employee.getJoinDate());
		 ps.setInt(7, employee.getLeaveAvi());
		 ps.setInt(8, employee.getManageID());
		 
		 
		 int x = ps.executeUpdate() ;
		 
		 if(x>0) {
			 result = "Employee Ragister Successfully Username and password has been send to employee" ;
		 }
		
		
	} catch (SQLException e) {
			result = e.getMessage() ;
	}
	
	
	return result ;
}

//////////////////////////////////////////////////////////////////////////////////////
//                            Transfer-employee to other dept
////////////////////////////////////////////////////////////////////////////////////

@Override
public String transferEmployee(int empId, int deptId) {

	String result = "Not Transfered" ;
	
	String query = "update employee set deptId = ? where empId = ?" ;
	
	try(Connection conn = DBUtil.provideConnection()) {
		
		PreparedStatement ps = conn.prepareStatement(query) ;
		ps.setInt(1, deptId);
		ps.setInt(2, empId);
		
		int x = ps.executeUpdate() ;
		if(x>0) {
			result = "Employee Transfered to other Department is successful." ;
		}
		
		
	} catch (SQLException e) {
		result = e.getMessage() ;
		
		
	}
	
	
	return result;
}

//////////////////////////////////////////////////////////////////////////////////////////
///////////////////  View -Department List   /////////////////////////////////////////////

@Override
public List<Department> viewDepartment() throws DepartmentException {
	
	List<Department> departments = new ArrayList<>() ;
	
	
	String query = "select * from department" ;
	
	try(Connection conn = DBUtil.provideConnection()) {
		PreparedStatement ps = conn.prepareStatement(query) ;
		ResultSet rs = ps.executeQuery() ;
		while(rs.next()) {
			int deptId = rs.getInt("deptId") ;
			String deptName = rs.getString("deptName") ;
			String deptLoc = rs.getString("deptLoc") ;
			
			Department dep = new Department(deptId, deptName, deptLoc) ;
			departments.add(dep) ;
		}
		
		if(departments.isEmpty()) {
			throw new DepartmentException("No Department exist please add department first") ;
		}
		
	} catch (SQLException e) {
		throw new DepartmentException(e.getMessage()) ;
	}

	
	return departments ;
	
	
}


///////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////  Leave List of Employee.  ///////////////////////////////////////

@Override
public List<Leaves> getLeavesList() throws EmployeeException {
	List<Leaves> list = new ArrayList<>() ;
	
	String query = "select * from leaves" ;
	try(Connection conn = DBUtil.provideConnection()) {
		
		PreparedStatement ps = conn.prepareStatement(query);
	    ResultSet rs = ps.executeQuery() ;
	
	
	while(rs.next()) {
		int empId = rs.getInt("empId") ;
		
		int leaveNo = rs.getInt("leaveNo") ;
		int leaveDay = rs.getInt("leaveday") ;
		String reason = rs.getString("reason") ;
		
		Leaves leaves = new Leaves(empId, leaveNo, leaveDay, reason) ;
	list.add(leaves) ;
	}

		
	} catch (SQLException e) {
		//System.out.println(e.getMessage());
		throw new EmployeeException(e.getMessage()) ;
	}

	
	return list ;
}

///////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////// Accept Leave Application ////////////////////////////////////////

@Override
public String acceptLeave(int empId) {
	
	String result = "No Action taken" ;
	
	String query = "select * from employee where empId = "+empId ;
	
	try(Connection conn = DBUtil.provideConnection()) {
		PreparedStatement ps = conn.prepareStatement(query) ;
		ResultSet rs = ps.executeQuery() ;
		if(rs.next()) {
			
			int ava = rs.getInt(1) ;
			
			String query2 = "select leaveDay from leaves where empId = "+empId ;
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ResultSet rs2 = ps2.executeQuery() ;
			if(rs2.next()) {
				int leave = rs2.getInt(1) ;
				if(ava>=leave) {
					String query3 = "delete from leaves where empId = "+empId ;
					PreparedStatement ps3 = conn.prepareStatement(query3);
					int x = ps3.executeUpdate() ;
					if(x>0) {
						result = "Leave request accepted" ;
					}
				}
				else {
					
					String query3 = "delete from leaves where empId = "+empId ;
					PreparedStatement ps3 = conn.prepareStatement(query3);
					int x = ps3.executeUpdate() ;
					if(x>0) {
						result = "This Employee don't have enough leaves left request rejected auto metically" ;
					}
					
				}
			}
			else {
				result = "Employee has not applied for the leave" ;
			}
			
		}else
		{
			result = "Enter right employee ID" ;
		}
		
	} catch (SQLException e) {
		result = e.getMessage() ;
	}

	
	
	return result ;
	
	
	
}



//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////// Reject Leave Application ////////////////////////////////////

@Override
public String rejectLeave(int empId) {
	
	
	String result = "No action taken something went wrong" ;
	
	
	
	try(Connection conn = DBUtil.provideConnection()) {
		String query2 = "select * from leaves where empId = "+empId ;
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ResultSet rs2 = ps2.executeQuery() ;
		if(rs2.next()) {
			
				String query3 = "delete from leaves where empId = "+empId ;
				PreparedStatement ps3 = conn.prepareStatement(query3);
				int x = ps3.executeUpdate() ;
				if(x>0) {
					result = "Leave request Rejected" ;
				}
			
		}
		else {
			result = "Employee has not applied for the leave" ;
		}
		
		
	} catch (SQLException e) {
		result = e.getMessage() ;
	}
	
	return result ;
	
	
}



	
	
	
	
	
	

}
