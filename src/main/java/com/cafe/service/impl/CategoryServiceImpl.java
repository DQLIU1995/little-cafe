package com.cafe.service.impl;
import com.cafe.mapper.CategoryMapper;
import com.cafe.pojo.Category;
import com.cafe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        return categoryMapper.getAll();
    }


    /*----------------------Select--------------------*/
    @Override
    public Category getById(Integer categoryId){
        Category category = categoryMapper.getById(categoryId);
        return category;
    }

    /*----------------------Delete---------------------*/
    @Override
    public void deleteById(Integer categoryId){
        categoryMapper.deleteById(categoryId);
    }


    /*--------------------insert---------------------*/
    @Override
    public void insert(Category category){
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insert(category);
    };

    /*------------------update----------------------*/
    @Override
    public void updateCategory(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.updateCategory(category);
    }
}
