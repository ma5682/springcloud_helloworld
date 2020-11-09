package com.offcn.controller;

import com.offcn.pojo.Movie;
import com.offcn.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/move")
    public Movie getMovie(){
       Movie movie= movieService.getMovie();
       movie.setMovieName(movie.getMovieName()+":"+port);
       return movie;
    }
}

