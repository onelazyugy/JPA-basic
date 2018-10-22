package com.vietle.productdata;

import com.vietle.productdata.findermethod.repos.ProductRepositoryFinderMethod;
import com.vietle.productdata.simplecrud.entities.Product;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindByMethodApplicationTest {
    @Autowired
    ProductRepositoryFinderMethod productRepositoryFinderMethod;

    @Test
    public void testFindByName() {
        List<Product> productList = productRepositoryFinderMethod.findByName("IWatch");
        productList.forEach(product -> {
            System.out.println(product.getPrice());
        });
    }

    @Test
    public void testFindByNameAndDesc() {
        List<Product> products = productRepositoryFinderMethod.findByNameAndDesc("Dryer", "From LG Inc");
        products.forEach(product -> {
            System.out.println(">>>>>>" + product.getPrice());
        });
    }

    @Test
    public void testFindByPriceGreaterThan() {
        List<Product> products = productRepositoryFinderMethod.findByPriceGreaterThan(200d);
        products.forEach(product -> {
            System.out.println(">>>>>>" + product.getName());
        });
    }

    @Test
    public void testFindByDescContains() {
        List<Product> products = productRepositoryFinderMethod.findByDescContains("LG");
        products.forEach(product -> {
            System.out.println(">>>>>>" + product.getName());
        });
    }

    @Test
    public void testFindByPriceBetween() {
        List<Product> products = productRepositoryFinderMethod.findByPriceBetween(100d, 1000d);
        products.forEach(product -> {
            System.out.println(">>>>>>" + product.getName());
        });
    }

    @Test
    public void testFindByDescLike() {
        List<Product> products = productRepositoryFinderMethod.findByDescLike("%LG%");
        products.forEach(product -> {
            System.out.println(">>>>>>" + product.getName());
        });
    }

    @Test
    public void testFindIdsIn() {
        List<Product> products = productRepositoryFinderMethod.findByIdIn(Arrays.asList(1, 4));
        products.forEach(product -> {
            System.out.println(">>>>>>" + product.getName());
        });
    }


    //Pagination
    @Test
    public void findAllPaging() {
        /**
         * if we have 4 rows, then 0,1 will give us first row
         * if we have 4 rows, then 0,2 will give us first 2 rows
         * if we have 4 rows, then 1,2 will give us last 2 rows
         * if we have 4 rows, then 1,1 will give us second row
         */
        Pageable pageable = PageRequest.of(0, 1);// 0 is the page, and size is 1
        Page<Product> products = productRepositoryFinderMethod.findAll(pageable);
        products.forEach(product -> {
            System.out.println(">>>>>>" + product.getName());
        });
    }

    //Sorting
    @Test
    public void testFindAllSorting() {
        //by default, direction is ASC
//        productRepositoryFinderMethod.findAll(Sort.by("name")).forEach(product -> {
//            System.out.println(">>>>>>" + product.getName());
//        });

        //sort by DESC
//        productRepositoryFinderMethod.findAll(Sort.by("name").descending()).forEach(product -> {
//            System.out.println(">>>>>>" + product.getName());
//        });

        //sort by multiple fields with 1 direction
//        productRepositoryFinderMethod.findAll(Sort.by("name", "price").descending()).forEach(product -> {
//            System.out.println(">>>>>>" + product.getName() + " >>>>>>" + product.getPrice());
//        });

        //sort by multiple fields with multiple directions
        productRepositoryFinderMethod.findAll(Sort.by(Sort.Order.desc("name"), Sort.Order.asc("price"))).forEach(product -> {
            System.out.println(">>>>>>" + product.getName() + " >>>>>>" + product.getPrice());
        });
    }

    //page and sort at the same time
    @Test
    public void testFindAllPagingAndSorting() {
        //0 = page #, 2 = size
        Pageable pageable = PageRequest.of(0, 2, Sort.Direction.DESC, "name");
        productRepositoryFinderMethod.findAll(pageable).forEach(product -> {
            System.out.println(">>>>>>" + product.getName());
        });
    }

    //
    @Test
    public void testFindIdsInWithPageable() {
        Pageable pageable = PageRequest.of(0, 2, Sort.Direction.ASC, "name");
        List<Product> products = productRepositoryFinderMethod.findByIdIn(Arrays.asList(1, 2, 3, 4), pageable);
        products.forEach(product -> {
            System.out.println(">>>>>>" + product.getName());
        });
    }
}
