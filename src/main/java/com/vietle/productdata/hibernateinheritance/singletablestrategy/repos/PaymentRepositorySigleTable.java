package com.vietle.productdata.hibernateinheritance.singletablestrategy.repos;

import com.vietle.productdata.hibernateinheritance.singletablestrategy.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepositorySigleTable extends CrudRepository<Payment, Integer> {

}
