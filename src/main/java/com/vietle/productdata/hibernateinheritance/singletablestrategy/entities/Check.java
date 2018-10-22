package com.vietle.productdata.hibernateinheritance.singletablestrategy.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * For check, ch will be the value in pmode column
 */
@Entity
@DiscriminatorValue("ch")
public class Check extends Payment{
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
