package com.dicka.springboot.demointegratedangular.dao;

import com.dicka.springboot.demointegratedangular.entity.Product;

import java.util.List;

public interface ProductDao {

    Product createProduct(Product product);

    Product updateProduct(Product product);

    Product disabledProduct(Product product);

    Product findIdproduct(String idproduct);

    //true
    List<Product> findAllProduct();

    //false
    List<Product> findDisabledProduct();

    Product findByname(String name);
}
