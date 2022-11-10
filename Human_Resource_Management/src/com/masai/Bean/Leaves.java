package com.masai.Bean;

public class Leaves {

	private int empId ;
	private int leaveNo ;
	private int leaveDay ;
	private String reason ;
	
	public Leaves() {
		// TODO Auto-generated constructor stub
	}

	public Leaves(int empId, int leaveNo, int leaveDay, String reason) {
		super();
		this.empId = empId;
		this.leaveNo = leaveNo;
		this.leaveDay = leaveDay;
		this.reason = reason;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getLeaveNo() {
		return leaveNo;
	}

	public void setLeaveNo(int leaveNo) {
		this.leaveNo = leaveNo;
	}

	public int getLeaveDay() {
		return leaveDay;
	}

	public void setLeaveDay(int leaveDay) {
		this.leaveDay = leaveDay;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Leaves [empId=" + empId + ", leaveNo=" + leaveNo + ", leaveDay=" + leaveDay + ", reason=" + reason
				+ "]";
	}
	
	
	
}
