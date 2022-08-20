package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Constants;
import com.example.demo.model.Employee;

@Service("employeeService1")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Employee> fetchAllEmployees() {
//		return empRepository.findAll();
		
		TypedQuery<Employee> query = em.createNamedQuery(Constants.SELECT_ALL_EMP, Employee.class);
		return query.getResultList();
		
	}

	@Override
	public Employee findEmployee(Long id) {
//		Employee emp = em.find(Employee.class, id);
		
		Optional<Employee> employee = empRepository.findById(id);
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
//		em.merge(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		empRepository.deleteById(id);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		empRepository.delete(employee);
//		em.remove(employee);
	}
	
}
