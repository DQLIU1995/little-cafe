package com.cafe.service;

import com.cafe.pojo.Category;

import java.time.LocalDateTime;
import java.util.List;

public interface CategoryService {


    List<Category> getAll();

    Category getById(Integer categoryId);

    void deleteById(Integer categoryId);


    void insert(Category category);


    void updateCategory(Category category);
}
