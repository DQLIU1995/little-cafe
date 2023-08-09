package com.cafe.mapper;

import com.cafe.pojo.Dish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {


    /*---------------------------------Select---------------------------------*/
    @Select("select * from dish")
    List<Dish> list();

    @Select("select * from dish where dish_id = #{dishId}")
    Dish selectByOneId(Integer dishId);

    @Select("select * from dish where category_id = #{category_id}")
    List<Dish>selectByCategoryId(Integer CategoryId);


    public List<Dish> selectByFilter(Integer dishId, String name, Integer categoryId);

    /* ---------------------------------Delete------------------------*/
    @Delete("delete from dish where dish_id = #{dishId}")
    public void deleteByOneId(Integer dishId);

    public void deleteByIds(List<Integer> dishIds);


    /* ---------------------------------Insert------------------------*/

    @Insert("insert into dish(name, category_id, price, image, description, create_time, update_time)" +
            "values(#{name}, #{categoryId}, #{price}, #{image}, #{description}, #{createTime}, #{updateTime})")
    public void insert(Dish dish);


    /* ---------------------------------Update------------------------*/
    public void updateDish(Dish dish);




}
