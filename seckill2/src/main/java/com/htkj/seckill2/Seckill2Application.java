package com.htkj.seckill2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.htkj.seckill2.mapper")
@SpringBootApplication
public class Seckill2Application {

    public static void main(String[] args) {
        SpringApplication.run(Seckill2Application.class, args);



    }

}
