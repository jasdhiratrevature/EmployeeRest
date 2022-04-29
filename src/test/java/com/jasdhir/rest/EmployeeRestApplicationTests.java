package com.jasdhir.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jasdhir.rest.controller.EmployeeController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeRestApplicationTests {

	@Autowired
	  EmployeeController employeeController;
	 
	  @Test
	  public void contextLoads() {
	//  Assertions.assertThat(employeeController).isNot(null);
	  Assertions.assertNotEquals(employeeController, null);
	    
	  }

}
