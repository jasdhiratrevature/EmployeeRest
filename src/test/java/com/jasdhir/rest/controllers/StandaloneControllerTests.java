package com.jasdhir.rest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.jasdhir.rest.controller.EmployeeController;
import com.jasdhir.rest.model.Employee;
import com.jasdhir.rest.repository.EmployeeRepository;





@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class StandaloneControllerTests {

	@MockBean
	EmployeeRepository employeeRepository;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testfindAll() throws Exception {
		Employee employee = new Employee("Jas", "j@k.com",12344);
		List<Employee> employees = Arrays.asList(employee);

		Mockito.when(employeeRepository.findAll()).thenReturn(employees);

		mockMvc.perform(get("/api/v1/employees"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].name", Matchers.is("Jas")));
	}

}
