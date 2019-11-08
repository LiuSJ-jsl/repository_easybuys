package com.htkj.seckill2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;

@MapperScan("com.htkj.seckill2.mapper")
@EnableEurekaClient
@SpringBootApplication
public class Seckill2Application {

    public static void main(String[] args) {
        SpringApplication.run(Seckill2Application.class, args);



    }

}
