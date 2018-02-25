package com.dicka.springboot.demointegratedangular.service.impl;

import com.dicka.springboot.demointegratedangular.dao.CategoryDao;
import com.dicka.springboot.demointegratedangular.entity.Category;
import com.dicka.springboot.demointegratedangular.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
        return categoryDao.getList();
    }

    @Override
    public Category getId(int idcategory) {
        return categoryDao.getId(idcategory);
    }

    @Override
    public Category saved(Category category) {
        return categoryDao.saved(category);
    }

    @Override
    public Category disabled(Category category) {
        return categoryDao.disabled(category);
    }
}
