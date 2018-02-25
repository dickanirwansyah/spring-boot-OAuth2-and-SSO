package com.dicka.springboot.demointegratedangular.service.impl;

import com.dicka.springboot.demointegratedangular.dao.ProductDao;
import com.dicka.springboot.demointegratedangular.entity.Product;
import com.dicka.springboot.demointegratedangular.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product createProduct(Product product) {
        return productDao.createProduct(product);
    }

    @Override
    public Product disabledProduct(Product product) {
        return productDao.disabledProduct(product);
    }

    @Override
    public Product findIdproduct(String idproduct) {
        return productDao.findIdproduct(idproduct);
    }

    @Override
    public Product findByName(String name) {
        return productDao.findByname(name);
    }

    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct();
    }

    @Override
    public List<Product> findDisabledProduct() {
        return productDao.findDisabledProduct();
    }
}
