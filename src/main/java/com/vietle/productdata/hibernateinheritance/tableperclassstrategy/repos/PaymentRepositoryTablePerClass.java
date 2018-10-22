package com.vietle.productdata.hibernateinheritance.tableperclassstrategy.repos;


import com.vietle.productdata.hibernateinheritance.tableperclassstrategy.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepositoryTablePerClass extends CrudRepository<Payment, Integer> {
}
