package com.zhongba.springboot.controller;

import com.zhongba.springboot.domain.User;
import com.zhongba.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/")
    public int count() {
        int userCount = userMapper.count();
        System.out.println(userCount);
        return userCount;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        User user = userMapper.getUser(id);
        return user;
    }
}
