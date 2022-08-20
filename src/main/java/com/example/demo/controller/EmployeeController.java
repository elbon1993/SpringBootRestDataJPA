package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeService2")
	EmployeeService empService;
	
	@GetMapping("employees")
	public AbstractResponse getEmployees() {
		EmployeeResponse response = new EmployeeResponse();
		response.setData(empService.fetchAllEmployees());
		response.setIsSuccess(true);
		response.setSuccessMsg("Successfully fetched all employees");
		return response;
	}
	
	@GetMapping("{id}")
	public AbstractResponse getEmployee(@PathVariable(name = "id") Long id) {
		EmployeeResponse response = new EmployeeResponse();
		response.setData(empService.findEmployee(id));
		return response;
	}
	
	@PostMapping
	public AbstractResponse saveEmployee(@RequestBody Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		empService.addEmployee(employee);
		return response;
	}
	
	@PutMapping
	public AbstractResponse updateEmployee(@RequestBody Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		empService.updateEmployee(employee);
		return response;
	}
	
	@DeleteMapping("{id}")
	public AbstractResponse deleteEmployee(@PathVariable(name="id") Long id) {
		EmployeeResponse response = new EmployeeResponse();
		empService.deleteEmployee(id);
		return response;
	}
}
