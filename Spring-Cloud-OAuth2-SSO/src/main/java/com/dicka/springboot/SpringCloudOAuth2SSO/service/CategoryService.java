package com.dicka.springboot.SpringCloudOAuth2SSO.service;

import com.dicka.springboot.SpringCloudOAuth2SSO.entity.Category;

import java.util.List;

public interface CategoryService {

    Category findId(int idcategory);

    List<Category> findAll();
}
