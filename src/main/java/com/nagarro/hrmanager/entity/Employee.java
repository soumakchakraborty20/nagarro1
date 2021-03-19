package com.nagarro.hrmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	
	@Id
	@Column(name="employeeCode")
	private long employeeCode;
	
	@Column(name="employeeName")
	private String employeeName;
	
	@Column(name="employeeEmail")
	private String employeeEmail;
	
	@Column(name="employeeLocation")
	private String employeeLocation;
	
	@Column(name="employeeDateOfBirth")
	private String employeeDateOfBirth;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long employeeCode, String employeeName, String employeeEmail, String employeeLocation,
			String employeeDateOfBirth) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeLocation = employeeLocation;
		this.employeeDateOfBirth = employeeDateOfBirth;
	}

	public long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(long employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeLocation() {
		return employeeLocation;
	}

	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}

	public String getEmployeeDateOfBirth() {
		return employeeDateOfBirth;
	}

	public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
		this.employeeDateOfBirth = employeeDateOfBirth;
	}
	
	
	
}
