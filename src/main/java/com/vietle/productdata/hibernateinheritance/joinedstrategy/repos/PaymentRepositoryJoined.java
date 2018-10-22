package com.vietle.productdata.hibernateinheritance.joinedstrategy.repos;

import com.vietle.productdata.hibernateinheritance.joinedstrategy.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepositoryJoined extends CrudRepository<Payment, Integer> {
}
