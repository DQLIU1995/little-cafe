package com.cafe.service.impl;


import com.cafe.mapper.UserMapper;
import com.cafe.pojo.User;
import com.cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getByUserId(Integer UserId) {
        return userMapper.getByUserId(UserId);
    }

}
