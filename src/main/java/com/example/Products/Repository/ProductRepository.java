package com.example.Products.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Products.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{

    Product findByMobileName(String name);

   Product findByMobileId(Long id);

}
