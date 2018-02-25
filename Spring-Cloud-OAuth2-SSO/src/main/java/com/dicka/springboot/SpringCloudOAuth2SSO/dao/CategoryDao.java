package com.dicka.springboot.SpringCloudOAuth2SSO.dao;

import com.dicka.springboot.SpringCloudOAuth2SSO.entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getList();

    Category findId(int idcategory);

}
