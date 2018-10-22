package com.vietle.productdata.hibernateinheritance.joinedstrategy.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id") // column 'id' in bankcheck table is a pk of payment table
//@Table(name = "bankcheck") // UNCOMMENT ME
public class Check extends Payment {
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}

