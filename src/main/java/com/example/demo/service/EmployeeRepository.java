package com.example.demo.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByName(String name);
	
	List<Employee> findBySalary(Integer salary);
	
	List<Employee> findByNameAndSalary(String name, Integer salary);
	
	
}
