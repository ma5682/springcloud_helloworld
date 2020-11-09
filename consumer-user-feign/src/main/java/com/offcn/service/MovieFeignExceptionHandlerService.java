package com.offcn.service;

import com.offcn.ConsumerUserFeignStart;
import com.offcn.pojo.Movie;
import org.springframework.stereotype.Component;
//异常处理类
@Component
public class MovieFeignExceptionHandlerService implements ConsumerUserFeignStart.MovieServiceFeign {
    @Override
    public Movie getMovie() {
        Movie movie = new Movie();
        movie.setId(-1);
        movie.setMovieName("无此电影呀...");
        return movie;
    }
}

