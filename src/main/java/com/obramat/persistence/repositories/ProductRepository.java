package com.obramat.persistence.repositories;

import com.obramat.persistence.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, CrudRepository<Product, Long> {

    List<Product> findByNameContaining(String name);
}
