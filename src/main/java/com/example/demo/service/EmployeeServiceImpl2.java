package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service("employeeService2")
public class EmployeeServiceImpl2 implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Employee> fetchAllEmployees() {
//		return empRepository.findAll();
		
//		return em.createNamedQuery(Constants.SELECT_ALL_EMP).getResultList().subList(0, 3);

		return empRepository.findByNameAndSalary("varam", 30000);
	}

	@Override
	@Transactional
	public Employee findEmployee(Long id) {
		Optional<Employee> employee = empRepository.findById(id);
		employee.get().setSalary(20000);
		return employee.isPresent()? employee.get(): null;
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
//		empRepository.save(employee);
		em.persist(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		empRepository.save(employee);
		
	}

	@Override
	public void deleteEmployee(Long id) {
		empRepository.deleteById(id);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		empRepository.delete(employee);
	}
	
}
