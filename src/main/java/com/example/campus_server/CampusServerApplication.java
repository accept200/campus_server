package com.example.campus_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.campus_server.mapper")
public class CampusServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampusServerApplication.class, args);
    }
}
