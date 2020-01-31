package com.redo.codeforfun.service;

import com.redo.codeforfun.model.UserDO;
import com.redo.codeforfun.model.dao.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService {

    @Resource
    private UserDao userDao;

    public UserDO getUserByUid() {
        UserDO userDO = userDao.getById(1);
        return userDO;
    }

}
