package com.dicka.springboot.SpringCloudOAuth2SSO.controller;

import com.dicka.springboot.SpringCloudOAuth2SSO.entity.Category;
import com.dicka.springboot.SpringCloudOAuth2SSO.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@EnableOAuth2Sso
@RestController
public class ControllerCategory {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/api/category/list")
    public ResponseEntity<List<Category>> getList(){
        return Optional.ofNullable(categoryService.findAll())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/api/category/{idcategory}")
    public ResponseEntity<Category> getId(@PathVariable("idcategory")String idcategory){
        return Optional.ofNullable(categoryService.findId(Integer.parseInt(idcategory)))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/login/callback")
    public ResponseEntity<String> getLogin(){
        return new ResponseEntity<String>("LOGIN CALLBACK",HttpStatus.OK);
    }
}
