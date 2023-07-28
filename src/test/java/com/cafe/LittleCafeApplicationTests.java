package com.cafe;

import com.cafe.mapper.DishMapper;
import com.cafe.pojo.Dish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class LittleCafeApplicationTests {

    /*---------dishMapper Test---------------*/
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

    }


}
