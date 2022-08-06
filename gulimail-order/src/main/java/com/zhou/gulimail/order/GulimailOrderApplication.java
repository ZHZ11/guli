package com.zhou.gulimail.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.zhou.gulimail.order.dao")
@EnableDiscoveryClient
public class GulimailOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimailOrderApplication.class, args);
    }

}
