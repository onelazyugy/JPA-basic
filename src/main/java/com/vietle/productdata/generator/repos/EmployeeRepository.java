package com.vietle.productdata.generator.repos;

import com.vietle.productdata.generator.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}

