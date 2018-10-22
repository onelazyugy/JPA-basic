package com.vietle.productdata.hibernateinheritance.tableperclassstrategy.entities;

import javax.persistence.*;

/**
 * parent class of credit card and check
 * ****TABLE_PER_CLASS strategy is not recommend as best practice****
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
