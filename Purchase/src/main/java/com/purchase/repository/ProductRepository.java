package com.purchase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purchase.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
