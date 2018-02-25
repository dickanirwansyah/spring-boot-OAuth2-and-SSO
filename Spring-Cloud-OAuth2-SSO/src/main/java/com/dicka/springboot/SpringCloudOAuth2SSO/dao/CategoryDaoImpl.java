package com.dicka.springboot.SpringCloudOAuth2SSO.dao;

import com.dicka.springboot.SpringCloudOAuth2SSO.entity.Category;
import com.dicka.springboot.SpringCloudOAuth2SSO.repository.CategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao{

    private final CategoryRepository categoryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public CategoryDaoImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getList() {
        String jpql = "SELECT c FROM Category c WHERE c.valide=true";
        return entityManager.createQuery(jpql)
                .getResultList();
    }

    @Override
    public Category findId(int idcategory) {
        return categoryRepository.findOne(idcategory);
    }
}
