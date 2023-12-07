package com.dbs.command;

import com.dbs.entity.Library;

/**
 * @author Jason He
 * @date 2023/12/5 19:25
 */
public class CmdUserLogin extends Command {
    @Override
    public void Process() {
        String userName=Parameters[1];
        String userPassword=Parameters[2];
        Library.userService.Login(userName,userPassword);
    }
}
