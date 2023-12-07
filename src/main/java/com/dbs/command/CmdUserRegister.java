package com.dbs.command;

import com.dbs.entity.Library;
import com.dbs.entity.User.UserType;

/**
 * @author Jason He
 * @date 2023/12/5 19:56
 */
public class CmdUserRegister extends Command {
    @Override
    public void Process() {
        UserType userRole= UserType.valueOf(Parameters[1]) ;
        String userName=Parameters[2];
        String userPassword=Parameters[3];
        Library.userService.Register(userName,userPassword,userRole);
    }

}
