package com.dicka.springboot.SpringCloudOAuth2SSO.service;

import com.dicka.springboot.SpringCloudOAuth2SSO.dao.CategoryDao;
import com.dicka.springboot.SpringCloudOAuth2SSO.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    @Override
    public Category findId(int idcategory) {
        return categoryDao.findId(idcategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.getList();
    }
}
