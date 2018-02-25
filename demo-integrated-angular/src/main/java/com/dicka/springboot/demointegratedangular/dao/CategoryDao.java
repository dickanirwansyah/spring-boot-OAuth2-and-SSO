package com.dicka.springboot.demointegratedangular.dao;

import com.dicka.springboot.demointegratedangular.entity.Category;

import java.util.List;

public interface CategoryDao {

    //list by true
    List<Category> getList();

    Category getId(int idcategory);

    Category disabled(Category category);

    Category saved(Category category);
}
