package com.jasdhir.rest.repos;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jasdhir.rest.model.Employee;
import com.jasdhir.rest.repository.EmployeeRepository;



@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {

  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  public void testCreateReadDelete() {
    Employee employee = new Employee("Jasdhir", "Singh@k.com",12345);

    employeeRepository.save(employee);

    Iterable<Employee> employees = employeeRepository.findAll();
    Assertions.assertThat(employees).extracting(Employee::getName).containsOnly("Jasdhir");

    employeeRepository.deleteAll();
    Assertions.assertThat(employeeRepository.findAll()).isEmpty();
  }
}
