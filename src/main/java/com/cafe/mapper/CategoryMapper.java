package com.cafe.mapper;
import com.cafe.pojo.Category;

import com.cafe.pojo.Dish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /*---------------------------------Select---------------------------------*/
    @Select("select * from category")
    public List<Category> getAll();

    @Select("select * from category where category_id = #{id}")
    public Category getById(Integer categoryId);


    /* ---------------------------------Delete------------------------*/
    @Delete("delete from category where category_id = #{categoryId}")
    public void deleteById(Integer categoryId);


    /* ---------------------------------Insert------------------------*/

    @Insert("insert into category(type, name, status)" +
            "values(#{type}, #{name}, #{status}")
    public void insert(Category category);


    /* ---------------------------------Update------------------------*/
    public void updateCategory(Category category);
}
