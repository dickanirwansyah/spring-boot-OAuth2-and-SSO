package com.dicka.springboot.demointegratedangular.service;

import com.dicka.springboot.demointegratedangular.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Product product);

    Product disabledProduct(Product product);

    Product findIdproduct(String idproduct);

    Product findByName(String name);

    List<Product> findAllProduct();

    List<Product> findDisabledProduct();
}
