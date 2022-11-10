package com.masai.Bean;

public class Employee {

	private int empId ;
	private String username ;
	private String password ;
	private String name ;
	private int deptId ;
	private int Salary ;
	private String joinDate ;
	private int leaveAvi ;
	private int manageID ;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String username, String password, String name, int deptId, int salary, String joinDate,
			int leaveAvi, int manageID) {
		super();
		this.empId = empId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.deptId = deptId;
		Salary = salary;
		this.joinDate = joinDate;
		this.leaveAvi = leaveAvi;
		this.manageID = manageID;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public int getLeaveAvi() {
		return leaveAvi;
	}

	public void setLeaveAvi(int leaveAvi) {
		this.leaveAvi = leaveAvi;
	}

	public int getManageID() {
		return manageID;
	}

	public void setManageID(int manageID) {
		this.manageID = manageID;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", deptId=" + deptId + ", Salary=" + Salary + ", joinDate=" + joinDate + ", leaveAvi=" + leaveAvi
				+ ", manageID=" + manageID + "]";
	}
	
	
	
	
	
	
	
}
