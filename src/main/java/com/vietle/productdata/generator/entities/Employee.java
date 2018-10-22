package com.vietle.productdata.generator.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Entity
public class Employee {
//    1. strategry use is IDENTITY, this is when you have id column is PK and AUTO_INCREMENT when you create the table
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

//  2. strategry use is TABLE, this is when you create 2 tables
//    @TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
//    @Id
//    @GeneratedValue(strategy= GenerationType.TABLE, generator = "employee_gen")
//    private Long id;

//  3. strategry use is random
//    @GenericGenerator(name = "emp_id", strategy = "com.vietle.productdata.generator.CustomRandomIDGenerator")
//    @GeneratedValue(generator = "emp_id")
//    @Id
//    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
