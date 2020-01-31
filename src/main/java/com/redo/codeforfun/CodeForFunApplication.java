package com.redo.codeforfun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.redo.codeforfun.model.dao")
public class CodeForFunApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeForFunApplication.class, args);
    }

}
