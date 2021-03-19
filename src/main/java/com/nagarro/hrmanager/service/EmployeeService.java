package com.nagarro.hrmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.hrmanager.entity.Employee;

@Service
public interface EmployeeService {

	public void saveEmployee(Employee employee);

	public List<Employee> allEmployee();

	public void updateEmployee(Employee employee);

	public void deleteEmployee(Employee employee);
	
	public Employee getEmployeeById(long id);
	
	public Employee deleteEmployeeById(long id);
    
	public List<Employee> listAll();
}
