package com.dicka.springboot.demointegratedangular.controller;

import com.dicka.springboot.demointegratedangular.entity.Category;
import com.dicka.springboot.demointegratedangular.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerCategory {

    @Autowired
    private CategoryService categoryService;


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/api/category/secure/list", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getList(){
        return Optional.ofNullable(categoryService.getAll())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.BAD_REQUEST));
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_STAFF')")
    @RequestMapping(value = "/api/category/secure/create", method = RequestMethod.POST)
    public ResponseEntity<Category> saved(@RequestBody Category category){
        return Optional.ofNullable(categoryService.saved(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/api/category/secure/disabled", method = RequestMethod.POST)
    public ResponseEntity<Category> disabled(@RequestBody Category category){
        return Optional.ofNullable(categoryService.disabled(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/api/category/secure/param", method = RequestMethod.GET)
    public ResponseEntity<Category> getId(@RequestParam("idcategory")String idcategory){
        return Optional.ofNullable(categoryService.getId(Integer.parseInt(idcategory)))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.NOT_FOUND));
    }
}
