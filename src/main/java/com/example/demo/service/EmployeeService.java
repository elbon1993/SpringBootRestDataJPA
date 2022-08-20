package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	List<Employee> fetchAllEmployees();
	
	Employee findEmployee(Long id);
	
	void addEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(Long id);
	
	void deleteEmployee(Employee employee);
}
