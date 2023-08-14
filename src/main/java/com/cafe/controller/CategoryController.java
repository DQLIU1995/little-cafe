package com.cafe.controller;
import com.cafe.pojo.Category;
import com.cafe.pojo.Result;
import com.cafe.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;


@Slf4j
@RestController
@RequestMapping("categories")
@CrossOrigin(origins = "${FRONTEND_ENDPOINT}")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /*----------------------GetMapping-----------------*/
    @GetMapping
    public Result list(){
        log.info("Search all category data");
        List<Category> categoryList = categoryService.getAll();
        return Result.success(categoryList);
    }

    @GetMapping("/{categoryId}")
    public Result selectByOneId(@PathVariable Integer categoryId){
        log.info("Get one list by its ID");
        Category category = categoryService.getById(categoryId);
        return Result.success(category);
    }

    /*----------------------DeleteMapping-----------------*/
    @DeleteMapping("/{categoryId}")
    public Result deleteByOneId(@PathVariable Integer categoryId){
        log.info("Delete one category by its ID");
        categoryService.deleteById(categoryId);
        return Result.success();
    }

    /*----------------------------update---------------------*/

    @PutMapping
    public Result updateCategory(@RequestBody Category category){
        log.info("update list");
        log.info(String.valueOf(category));
        log.info(String.valueOf(category.getCategoryId()));
        log.info(String.valueOf(category.getType()));
        log.info(String.valueOf(category.getName()));
        categoryService.updateCategory(category);
        return Result.success();
    }


    /*----------------------------insert---------------------*/
    @PostMapping
    public Result addCategory(@RequestBody Category category){
        log.info("add another category: {}", category);
        categoryService.insert(category);
        return Result.success();
    }

}
