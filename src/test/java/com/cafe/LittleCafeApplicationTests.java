package com.cafe;

import com.cafe.mapper.CategoryMapper;
import com.cafe.mapper.DishMapper;
import com.cafe.mapper.UserMapper;
import com.cafe.pojo.Category;
import com.cafe.pojo.Dish;
import com.cafe.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class LittleCafeApplicationTests {

/*    *//*---------dishMapper Test---------------*//*
    @Autowired
    private DishMapper dishMapper;

    @Test
    public void testDeleteByOneId(){
        dishMapper.deleteByOneId(1007);
    }

    @Test
    public void testSelectByFilter() {
        List<Dish> dishes = dishMapper.selectByFilter(1001, null, null);
        System.out.println(dishes);
    }

    @Test
    public void testUpdateDish(){
        Dish dish = new Dish();
        dish.setDishId(1006);
        dish.setName("Chocolate Ice Cream");
        dishMapper.updateDish(dish);
    }

    @Test
    public void testDeleteByIds() {
        List<Integer> dishIds = Arrays.asList(1013, 1014, 1015);
        dishMapper.deleteByIds(dishIds);
    }

    @Test
    public void testInsert(){
        Dish dish = new Dish();

        dish.setName("surprised dish");
        dish.setCategoryId(1);
        dish.setPrice(BigDecimal.valueOf(5.50));
        dish.setImage("123.jpg");
        dish.setDescription(null);
        dish.setCreateTime(LocalDateTime.now());
        dish.setUpdateTime(LocalDateTime.now());

        dishMapper.insert(dish);
    }



    *//*---------UserMapper Test---------------*//*

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetByUserId() {userMapper.getByUserId(10001);}

    @Test
    public void testGetAllUser() {userMapper.getAllUser();}


    *//*---------CategoryMapper Test---------------*//*

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testGetAll() {
        categoryMapper.getAll();
    }

    @Test
    public void testGetById(){categoryMapper.getById(101); }

    @Test
    public void testInsertCategory() {
        Category category = new Category();
        category.setType(1);
        category.setName("Surprise Category");
        category.setStatus(0);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insert(category);

    }*/


}
