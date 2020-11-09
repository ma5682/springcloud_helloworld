package com.offcn;

import com.offcn.pojo.Movie;
import com.offcn.service.MovieFeignExceptionHandlerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableDiscoveryClient
//开启Feign功能
@EnableFeignClients
//开启断路保护功能
@EnableCircuitBreaker
//开启可视化监控功能
@EnableHystrixDashboard
public class ConsumerUserFeignStart {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserFeignStart.class,args);
    }

    @FeignClient(value = "PROVIDERMOVIE",fallback = MovieFeignExceptionHandlerService.class )
    public interface MovieServiceFeign{
        @GetMapping("/move")
        public Movie getMovie();
    }
}

