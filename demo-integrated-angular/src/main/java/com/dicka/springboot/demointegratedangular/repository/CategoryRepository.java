package com.dicka.springboot.demointegratedangular.repository;

import com.dicka.springboot.demointegratedangular.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
}
