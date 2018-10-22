package com.vietle.productdata.hibernateinheritance.joinedstrategy.entities;

import javax.persistence.*;

/**
 * parent class of credit card and check
 * JOINED IS MOST WIDELY USE
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {
    @Id
    private int id;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
