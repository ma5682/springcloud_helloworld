package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    //获取用户信息
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return   userService.getUser(id);

    }

    //获取购买信息
    @GetMapping("/movie/{id}")
    public Map<String,Object> getbuyMovie(@PathVariable("id")Integer id){
        return userService.buyMovie(id);
    }

}

