package com.dicka.springboot.demointegratedangular.service.impl;

import com.dicka.springboot.demointegratedangular.entity.Product;
import com.dicka.springboot.demointegratedangular.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductService productService;

    @Override
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    @Override
    public Product disabledProduct(Product product) {
        return productService.disabledProduct(product);
    }

    @Override
    public Product findIdproduct(String idproduct) {
        return productService.findIdproduct(idproduct);
    }

    @Override
    public Product findByName(String name) {
        return productService.findByName(name);
    }

    @Override
    public List<Product> findAllProduct() {
        return productService.findAllProduct();
    }

    @Override
    public List<Product> findDisabledProduct() {
        return productService.findDisabledProduct();
    }
}
