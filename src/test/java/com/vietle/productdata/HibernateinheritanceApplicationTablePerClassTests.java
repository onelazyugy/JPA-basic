package com.vietle.productdata;

import com.vietle.productdata.hibernateinheritance.tableperclassstrategy.entities.Check;
import com.vietle.productdata.hibernateinheritance.tableperclassstrategy.entities.CreditCard;
import com.vietle.productdata.hibernateinheritance.tableperclassstrategy.repos.PaymentRepositoryTablePerClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateinheritanceApplicationTablePerClassTests {
    @Autowired
    private PaymentRepositoryTablePerClass paymentRepository;

    // TABLE PER CLASS
    @Test
    public void createCreditCardPayment_SingleTable() {
        CreditCard cc = new CreditCard();
        cc.setId(124);
        cc.setAmount(500);
        cc.setCardnumber("123456789");

        paymentRepository.save(cc);
    }

    @Test
    public void createCheckPayment_SingleTable() {
        Check check = new Check();
        check.setId(456);
        check.setAmount(1000);
        check.setChecknumber("123456789");

        paymentRepository.save(check);
    }
    // END TABLE PER CLASS
}
