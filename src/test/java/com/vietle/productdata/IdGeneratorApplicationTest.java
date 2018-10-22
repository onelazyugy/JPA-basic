package com.vietle.productdata;

import com.vietle.productdata.generator.entities.Employee;
import com.vietle.productdata.generator.repos.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdGeneratorApplicationTest {
    @Autowired
    EmployeeRepository employeeRepository;


    @Test
    public void testCreateEmployeeIdentityStrategy() {
        Employee employee = new Employee();
        employee.setName("Viet");
        this.employeeRepository.save(employee);
    }

    @Test
    public void testCreateEmployeeTableStrategy() {
        Employee employee = new Employee();
        employee.setName("Viet");
        this.employeeRepository.save(employee);
    }

    @Test
    public void testCreateEmployeeRandomStrategy() {
        Employee employee = new Employee();
        employee.setName("Viet");
        this.employeeRepository.save(employee);
    }
}
