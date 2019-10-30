package com.freesun.votemanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.freesun.votemanager.mapper"})
public class VotemanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotemanagerApplication.class, args);
    }

}
