package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.EmployeeDto;
import com.masai.Exceptions.EmployeeException;
import com.masai.Utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	
	//////////////////////////////////////////// ///////////////////////////////////////
	////////////////          Employee login  ////////////////////////////////////////
	
	@Override
	public String loginEmployee(String username, String password) throws EmployeeException {
		
		
		
        String res = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where username = ? && password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("username");
//				String pass = rs.getString("password");
				rs.getString("password");
				
				res = name;
			}else {
				throw new EmployeeException("Invalid Username or password.. ");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

		return res;
		
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////  Profile view by employee //////////////////////////////
	
	
	
	
	@Override
	public List<EmployeeDto> getProfiledata(int empId) throws EmployeeException {
		
		
List<EmployeeDto> dtos = new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from employee e inner join department d on d.deptId = e.deptId where e.empId = ?");
												
			
			ps.setInt(1, empId);
			
			ResultSet rs=  ps.executeQuery();
			
			
			while(rs.next()) {
				
				
				EmployeeDto dto = new EmployeeDto();
				dto.setEmpId(rs.getInt("empId"));
				dto.setUsername(rs.getString("username"));
				dto.setName(rs.getString("name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setJoinDate(rs.getDate("joinDate"));
				dto.setLeaveAvi(rs.getInt("leaveAvi"));
				dto.setDeptId(rs.getInt("deptId"));
				dto.setManageID(rs.getInt("manageID"));
				dto.setDeptName(rs.getString("deptName"));
				dto.setDeptLoc(rs.getString("deptLoc"));
				
				
				dtos.add(dto);
				
				
			}
			
			
			if(dtos.size() == 0)
				throw new EmployeeException("No Student enrolled in that course");
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new EmployeeException(e.getMessage());
		}
		
		
		return dtos;
	
		
	}




	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	////////////////////   Apply For Leave   ///////////////////////////////////////////////
	
	
	@Override
	public String applyForLeave(int empId, int day, String resaon) {
String result = "Not applied for leaves" ;
		
		String query = "insert into leaves(empId , leaveDay , reason) values(?,?,?)" ;
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empId);
			ps.setInt(2, day);
			ps.setString(3, resaon);
			
			int x = ps.executeUpdate() ;
			
			if( x > 0) {
				result = "You have applied for leave wait for admin to take action" ;
			}
			
			
		} catch (SQLException e) {
			
			result = e.getMessage() ;

		}
	
		
		return result ;
	}


	
	
	////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////   Updating password by Employee -self.

	@Override
	public String updatePassword(int empId, String password) {
		
        String result = "Password Not changed" ;
		
		String query = "update employee set password = ? where empId = ?" ;
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement(query) ;
			ps.setString(1, password);
			ps.setInt(2, empId);
			int x = ps.executeUpdate() ;
			if(x > 0) {
				result = "Password changed successfully" ;
			}
			
			
		} catch (SQLException e) {
			result = e.getMessage() ;
		}
		
		
		
		
		
		
		return result ;
		
		
		
	}
	
	

	

}
