package com.vietle.productdata.simplecrud.repos;

import com.vietle.productdata.simplecrud.entities.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository<Product, Integer>
 * Product is the entity this repository will use
 * Integer is the type for the 'id' field in the Product entity
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
