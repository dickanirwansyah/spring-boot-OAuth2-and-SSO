package com.dicka.springboot.demointegratedangular.dao.impl;

import com.dicka.springboot.demointegratedangular.dao.CategoryDao;
import com.dicka.springboot.demointegratedangular.entity.Category;
import com.dicka.springboot.demointegratedangular.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getList() {
        String jpql = "SELECT c FROM Category c WHERE c.valid=true";
        return entityManager.createQuery(jpql)
                .getResultList();
    }

    @Override
    public Category getId(int idcategory) {
        return categoryRepository.findOne(idcategory);
    }

    @Override
    public Category disabled(Category category) {
        if(!entityManager.contains(category))
            category.setValid(false);
            category = entityManager.merge(category);
        return category;
    }

    @Override
    public Category saved(Category category) {
        if(category.getIdcategory() !=0){
            categoryRepository.save(category);
        }else{
            category.setValid(true);
            categoryRepository.save(category);
        }
        return category;
    }
}
