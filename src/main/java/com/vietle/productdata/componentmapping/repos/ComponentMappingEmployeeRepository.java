package com.vietle.productdata.componentmapping.repos;

import com.vietle.productdata.componentmapping.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface ComponentMappingEmployeeRepository extends CrudRepository<Employee, Integer> {
}
