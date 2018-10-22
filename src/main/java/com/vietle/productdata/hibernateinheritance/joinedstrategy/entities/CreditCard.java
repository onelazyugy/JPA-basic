package com.vietle.productdata.hibernateinheritance.joinedstrategy.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@Table(name = "card") // UNCOMMENT ME
@PrimaryKeyJoinColumn(name = "id")// column 'id' in card table is a pk of payment table
public class CreditCard extends Payment {
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
