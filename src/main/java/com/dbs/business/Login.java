package com.dbs.business;

import com.dbs.entity.Library;
import com.dbs.service.UserService;

/**
 * @author Jason He
 * @date 2023/12/5 19:25
 */
public class Login extends Business{
    @Override
    public void Process() {
        String userName=BusinessParameters[1];
        String userPassword=BusinessParameters[2];
        Library.userService.Login(userName,userPassword);
    }
}