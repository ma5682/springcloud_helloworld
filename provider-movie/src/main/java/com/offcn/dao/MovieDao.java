package com.offcn.dao;

import com.offcn.pojo.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {


    public Movie getMovie(){
        Movie movie=new Movie();
        movie.setId(1);
        movie.setMovieName("魁拔4");
        return movie;
    }
}

