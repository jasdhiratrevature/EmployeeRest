package com.jasdhir.rest.client;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jasdhir.rest.model.Employee;


public class RestClient {
	public static void main(String[] args) {
      useForObject();  
    useForEntity();
     useExchangeAPI();
     }
	
	public static void useExchangeAPI() {
		RestTemplate restTemplate = new RestTemplate();
		 HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	       
	         
	        HttpEntity<String> entity = new HttpEntity<String>(headers);
	         
	        ResponseEntity<Employee> responseEntity = restTemplate.exchange("http://localhost:9090/api/v1/employees/7", HttpMethod.GET, entity, Employee.class);
	        System.err.println("Employee Name Using Exchange API " +responseEntity.getBody().getName());
	}
	
	public static void useForObject() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp=restTemplate.getForObject("http://localhost:9090/api/v1/employees/5",Employee.class);
        System.err.println("Employee Name Using ForObject Method " +emp.getName());
        
      //Employee e1=new Employee("jas10Mar","jas10Mar","jas25Feb@jas25Feb.com");

        //  Employee addedEmp= restTemplate.postForObject("http://localhost:9090/api/v1/employees",e1,Employee.class);
		
	}
	public static void useForEntity() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> emp=restTemplate.getForEntity("http://localhost:9090/api/v1/employees/7",Employee.class);
	       System.err.println("Employee Name Using ForEntity Method " +emp.getBody().getName());
		
	}
}
