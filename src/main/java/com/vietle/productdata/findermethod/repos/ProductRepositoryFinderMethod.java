package com.vietle.productdata.findermethod.repos;

import com.vietle.productdata.simplecrud.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * simple follow naming convention and spring data will do its magic
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
 * extends CrudRepository for regular CRUD
 * extends PagingAndSortingRepository for CRUD, sort, and pagination
 */
//public interface ProductRepositoryFinderMethod extends CrudRepository<Product, Integer> {
public interface ProductRepositoryFinderMethod extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameAndDesc(String name, String desc);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByDescContains(String desc);
    List<Product> findByPriceBetween(Double start, Double end);
    List<Product> findByDescLike(String desc);
    List<Product> findByIdIn(List<Integer> ids);

    List<Product> findByIdIn(List<Integer> ids, Pageable pageable);
}
