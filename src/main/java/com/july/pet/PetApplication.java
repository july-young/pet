package com.july.pet;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: july
 * @date: 2020/7/31 09:57
 * @description: spring boot 启动类
 */
@EnableSwagger2Doc
@MapperScan("com.july.pet.dao")
@SpringBootApplication
public class PetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetApplication.class, args);
    }

}
