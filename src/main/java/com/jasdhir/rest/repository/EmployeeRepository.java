package com.jasdhir.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jasdhir.rest.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select e from Employee e where e.name like %:name%")
	List<Employee> findEmployeesByName(@Param("name") String empName);
}
