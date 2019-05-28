package com.edu.cqu.bysj.rfidcar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.edu.cqu.bysj.rfidcar.mapper")
public class RfidcarApplication {


    public static void main(String[] args) {
        SpringApplication.run(RfidcarApplication.class, args);
    }

}
