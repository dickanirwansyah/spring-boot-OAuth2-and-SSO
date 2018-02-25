package com.dicka.springboot.demointegratedangular.dao.impl;

import com.dicka.springboot.demointegratedangular.dao.ProductDao;
import com.dicka.springboot.demointegratedangular.entity.Product;
import com.dicka.springboot.demointegratedangular.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product createProduct(Product product) {
        if(product.getIdproduct() == null){
            product.setValid(true);
            product.setImage("poto-"+ UUID
                    .randomUUID()
                    .toString()
                    .substring(25)+".jpg");
            productRepository.save(product);
        }else if (product.getIdproduct() != null){
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public Product disabledProduct(Product product) {
        if(product.getIdproduct()!=null){
            product.setValid(false);
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public Product findIdproduct(String idproduct) {
        return productRepository.findOne(idproduct);
    }

    @Override
    public List<Product> findAllProduct() {
        String jpql="SELECT p FROM Product p WHERE p.valid=true";
        return entityManager.createQuery(jpql)
                .getResultList();
    }

    @Override
    public List<Product> findDisabledProduct() {
        String jpql="SELECT p FROM Product p WHERE p.valid=false";
        return entityManager.createQuery(jpql)
                .getResultList();
    }

    @Override
    public Product findByname(String name) {
        String jpql="SELECT p FROM Product p WHERE p.name=:name";
        return (Product) entityManager.createQuery(jpql).setParameter(1, name)
                .getSingleResult();
    }
}
