package com.vietle.productdata;

import com.vietle.productdata.componentmapping.entities.Address;
import com.vietle.productdata.componentmapping.entities.Employee;
import com.vietle.productdata.componentmapping.repos.ComponentMappingEmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComponentmappingApplicationTest {

    @Autowired
    private ComponentMappingEmployeeRepository componentMappingEmployeeRepository;

    @Test
    public void testCreate() {
        Employee employee = new Employee();
        employee.setId(123);
        employee.setName("Viet");
        Address address = new Address();
        address.setCity("Austin");
        address.setStreetaddress("spice wood spring");
        address.setCountry("USA");
        address.setState("Ga");
        address.setZipcode("30341");
        employee.setAddress(address);
        componentMappingEmployeeRepository.save(employee);
    }
}
