package com.vietle.productdata.hibernateinheritance.singletablestrategy.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * For credit card, cc will be the value in pmode column
 */
@Entity
@DiscriminatorValue("cc")
public class CreditCard extends Payment{
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
