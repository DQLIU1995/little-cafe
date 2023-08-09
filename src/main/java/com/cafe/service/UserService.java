package com.cafe.service;


import com.cafe.pojo.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getByUserId(Integer UserId);

}