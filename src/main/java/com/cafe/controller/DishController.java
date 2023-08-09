package com.cafe.controller;

import com.cafe.pojo.Dish;
import com.cafe.pojo.Result;
import com.cafe.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;


@Slf4j
@RestController
@RequestMapping("/dishes")
@CrossOrigin(origins = "http://localhost:3000")
public class DishController {

    @Autowired
    private DishService dishService;

    /*----------------------GetMapping-----------------*/
    @GetMapping
    public Result list(){
        log.info("Search all dish data");
        List<Dish> dishList = dishService.list();
        return Result.success(dishList);
    }

    @GetMapping("/filter")
    public Result selectByFilter(@RequestParam(required = false) Integer dishId,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Integer categoryId){
        log.info("Select filtered dishes");
        List<Dish> dishList = dishService.selectByFilter(dishId, name, categoryId);
        return Result.success(dishList);
    }

    @GetMapping("/{dishId}")
    public Result selectByOneId(@PathVariable Integer dishId){
        log.info("Get one list by its ID");
        Dish dish = dishService.selectByOneId(dishId);
        return Result.success(dish);
    }

    @GetMapping("/category/{categoryId}")
    public Result selectByCategoryId(@PathVariable Integer categoryId){
        log.info("Get one list by its ID");
        List<Dish> dishList = dishService.selectByCategoryId(categoryId);
        return Result.success(dishList);
    }


    /*----------------------DeleteMapping-----------------*/
    @DeleteMapping("/{dishId}")
    public Result deleteByOneId(@PathVariable Integer dishId){
        log.info("Delete one dish by its ID: {}", dishId);
        dishService.deleteByOneId(dishId);
        return Result.success();
    }

    @DeleteMapping
    public Result deleteByIds(List<Integer> dishIds){
        log.info("Delete by Multiple Ids");
        dishService.deleteByIds(dishIds);
        return Result.success();
    }

    /*----------------------------update---------------------*/

    @PutMapping
    public Result updateDish(@RequestBody Dish dish){
        log.info("update list");
        dishService.updateDish(dish);
        return Result.success();
    }


    /*----------------------------insert---------------------*/
    @PostMapping
    public Result addDish(@RequestBody Dish dish){
        log.info("add another dish: {}", dish);
        dishService.insert(dish);
        return Result.success(dish);
    }

}
