package com.offcn.service;

import com.offcn.ConsumerUserFeignStart;
import com.offcn.dao.UserDao;
import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ConsumerUserFeignStart.MovieServiceFeign movieServiceFeign;

    //根据Id获得对象
    public User getUser(Integer id){
       User user = userDao.getUser(id);
       return user;
    }

    //购买最新电影票

    public Map<String,Object> buyMovie(Integer id){

        Map<String,Object> result =new HashMap<>();
        //用户
        result.put("user",this.getUser(id));

        //查询电影票
        Movie movie=movieServiceFeign.getMovie();
        result.put("movie",movie);
        return result;


    }
}

