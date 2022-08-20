package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	@Qualifier("employeeService2")
	EmployeeService empService;
	
	@Test
	public void fetchAllEETest() throws Exception {
		Employee emp = new Employee();
		emp.setId(1L);
		emp.setName("chandu");
		emp.setSalary(20000);
		
		when(empService.fetchAllEmployees()).thenReturn(Arrays.asList(emp));
		
		this.mockMvc.perform(get("/employee/employees")).andDo(print()).andExpect(status().isOk());
	}
}
