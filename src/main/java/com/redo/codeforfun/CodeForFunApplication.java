package com.redo.codeforfun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.redo.codeforfun.model.dao")
@ImportResource(locations = {"classpath:dubbo-config.xml"})
public class CodeForFunApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeForFunApplication.class, args);
    }

}
