package com.jasdhir.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee_rest")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private int phone;
	public Employee(String name, String email, int phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	
	
}
