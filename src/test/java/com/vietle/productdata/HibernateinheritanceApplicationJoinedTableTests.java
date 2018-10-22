package com.vietle.productdata;

import com.vietle.productdata.hibernateinheritance.joinedstrategy.entities.Check;
import com.vietle.productdata.hibernateinheritance.joinedstrategy.entities.CreditCard;
import com.vietle.productdata.hibernateinheritance.joinedstrategy.repos.PaymentRepositoryJoined;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateinheritanceApplicationJoinedTableTests {
    @Autowired
    private PaymentRepositoryJoined paymentRepositoryJoined;

    // JOINED TABLE STRATEGY
    // save into payment table and card table
    @Test
    public void createCreditCardPayment_JoinedTable() {
        CreditCard cc = new CreditCard();
        cc.setId(444);
        cc.setAmount(250);
        cc.setCardnumber("0987654321");

        paymentRepositoryJoined.save(cc);
    }

    // save into payment table and bankcheck table
    @Test
    public void createCheckPayment_SingleTable() {
        Check check = new Check();
        check.setId(555);
        check.setAmount(1000);
        check.setChecknumber("123456789");

        paymentRepositoryJoined.save(check);
    }
    // END JOINED TABLE STRATEGY TEST
}
