package com.vietle.productdata;

import com.vietle.productdata.simplecrud.entities.Product;
import com.vietle.productdata.simplecrud.repos.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {

    @Autowired
    ProductRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone X");
		product.setDesc("latest iphone");
		product.setPrice(1000d);

		this.repository.save(product);
	}

	@Test
    public void testRead() {
	    Product product = this.repository.findById(1).get();
        Assert.assertNotNull(product);
        Assert.assertEquals("Iphone X", product.getName());
    }

    @Test
    public void testUpdate() {
        Product product = this.repository.findById(1).get();
        product.setPrice(1200d);
        this.repository.save(product);

        product = this.repository.findById(1).get();
        Assert.assertTrue(product.getPrice() == 1200d);
    }

    @Test
    public void testDelete() {
	    if(this.repository.existsById(1)) {
            this.repository.deleteById(1);
        }
    }

    @Test
    public void testCount() {
        System.out.println("COUNT: " + this.repository.count());
    }
}
