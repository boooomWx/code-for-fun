package com.redo.codeforfun.controller;

import com.redo.codeforfun.model.UserDO;
import com.redo.codeforfun.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class TestControl {

    @Resource
    private UserService userService;

    @GetMapping(value = "/testHelloWorld")
    public String testHelloWorld() {
        return "hello world";
    }

    @GetMapping(value = "/findUser")
    public String findUser() {
        UserDO userDO = userService.getUserByUid();
        return "name: " + userDO.getName() + " and age: " + userDO.getAge();
    }
}
