package com.dicka.springboot.demointegratedangular.repository;

import com.dicka.springboot.demointegratedangular.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
