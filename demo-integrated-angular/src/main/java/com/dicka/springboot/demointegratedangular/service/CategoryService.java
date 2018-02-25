package com.dicka.springboot.demointegratedangular.service;

import com.dicka.springboot.demointegratedangular.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getId(int idcategory);

    Category saved(Category category);

    Category disabled(Category category);
}
