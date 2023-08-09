package com.cafe.service;

import com.cafe.pojo.Dish;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DishService {
    List<Dish> list();

    Dish selectByOneId(Integer dishId);

    List<Dish> selectByCategoryId(Integer CategoryId);


    List<Dish> selectByFilter(Integer dishId, String name, Integer categoryId);

    void deleteByOneId(Integer dishId);

    void deleteByIds(List<Integer> dishIds);

    void insert(Dish dish);

    void updateDish(Dish dish);


}
