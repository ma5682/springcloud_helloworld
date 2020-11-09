package com.offcn.dao;

import com.offcn.pojo.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public class UserDao implements Serializable {

    public User getUser(Integer id){
        User user =new User();
        user.setId(id);
        user.setUserName("张三");
        return user;
    }
}

