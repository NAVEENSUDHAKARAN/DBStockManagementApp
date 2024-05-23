package com.chainsys.servlet;

public class UserDetails {

	String Name, DOB, EmpId, updatedName;

//	public UserDetails() {
//		Name = name;
//		DOB = dOB;
//		EmpId = empId;
//	}

	public String getUpdatedName() {
		return updatedName;
	}

	public void setUpdatedName(String updatedName) {
		this.updatedName = updatedName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}

	
}
