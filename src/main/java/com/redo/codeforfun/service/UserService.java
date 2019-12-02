package com.redo.codeforfun.service;

import com.redo.codeforfun.model.UserDO;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    public UserDO getUserByUid() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("redo");
        userDO.setAge(18);
        return userDO;
    }

}
