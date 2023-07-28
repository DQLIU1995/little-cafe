package com.cafe.service.impl;

import com.cafe.mapper.DishMapper;
import com.cafe.pojo.Dish;
import com.cafe.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    /*----------------------Select--------------------*/
    @Override
    public List<Dish> list() {
        return dishMapper.list();
    }

    @Override
    public List<Dish> selectByFilter(Integer dishId, String name, Integer categoryId){
        List<Dish> dishList = dishMapper.selectByFilter(dishId, name, categoryId);
        return dishList;
    }

    @Override
    public Dish selectByOneId(Integer dishId) {
        Dish dish = dishMapper.selectByOneId(dishId);
        return dish;
    }

    /*----------------------Delete---------------------*/
    @Override
    public void deleteByOneId(Integer dishId){dishMapper.deleteByOneId(dishId);}

    @Override
    public void deleteByIds(List<Integer> dishIds){dishMapper.deleteByIds(dishIds);}



    /*--------------------insert---------------------*/
    @Override
    public void insert(Dish dish){
        dish.setCreateTime(LocalDateTime.now());
        dish.setUpdateTime(LocalDateTime.now());

        dishMapper.insert(dish);
    };

    /*------------------update----------------------*/
    @Override
    public void updateDish(Dish dish){
        dish.setUpdateTime(LocalDateTime.now());
        dishMapper.updateDish(dish);
    };

}
