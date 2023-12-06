package com.dbs.business;

import com.dbs.entity.Library;
import com.dbs.entity.User.UserType;

/**
 * @author Jason He
 * @date 2023/12/5 19:56
 */
public class UserRegister extends Business{
    @Override
    public void Process() {
        UserType userRole= UserType.valueOf(BusinessParameters[1]) ;
        String userName=BusinessParameters[2];
        String userPassword=BusinessParameters[3];
        Library.userService.Register(userName,userPassword,userRole);
    }

}
