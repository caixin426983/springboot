package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example"})
@MapperScan("com.example.mapper")
@SpringBootApplication
public class SpringbootApplication {

    protected static final Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

    public static void main(String[] args) {

        logger.info("SpringBoot开始加载");

        SpringApplication.run(SpringbootApplication.class, args);

        logger.info("SpringBoot加载完毕");
    }


}
