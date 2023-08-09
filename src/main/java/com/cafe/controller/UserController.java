package com.cafe.controller;

import com.cafe.pojo.User;
import com.cafe.pojo.Result;
import com.cafe.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;


@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    /*----------------------GetMapping-----------------*/
    @GetMapping
    public Result getAllUser(){
        log.info("Search all user data");
        List<User> userList = userService.getAllUser();
        return Result.success(userList);
    }

    @GetMapping("/{userId}")
    public Result selectByOneId(@PathVariable Integer userId){
        log.info("Get one list by its ID");
        User user = userService.getByUserId(userId);
        return Result.success(user);
    }
}
