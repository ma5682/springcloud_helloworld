package com.offcn.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.offcn.dao.UserDao;
import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    //根据Id获得对象
    public User getUser(Integer id){
       User user = userDao.getUser(id);
       return user;
    }

    //购买最新电影票
    @HystrixCommand(fallbackMethod = "buyMovieFallbackMethod")
    public Map<String,Object> buyMovie(Integer id){

        Map<String,Object> result =new HashMap<>();
        //用户
        result.put("user",this.getUser(id));

        //查询电影票
        Movie movie=restTemplate.getForObject("http://PROVIDERMOVIE/move",Movie.class);
        result.put("movie",movie);
        return result;


    }

    //熔断时调用方法
    public Map<String,Object> buyMovieFallbackMethod(Integer id){
        User user =new User();
        user.setId(-1);
        user.setUserName("啥人没有");
        Movie movie =new Movie();
        movie.setId(00);
        movie.setMovieName("没票");
        Map<String,Object> result =new HashMap<>();
        result.put("user",user);
        result.put("movie",movie);
        return result;
    }
}

