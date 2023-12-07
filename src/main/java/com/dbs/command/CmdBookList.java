package com.dbs.command;

import com.dbs.entity.Library;
import com.dbs.entity.User;

/**
 * @author Jason He
 * @date 2023/12/6 17:18
 */
public class CmdBookList extends Command {
    @Override
    public void Process() {
        //check if has user login
        User user=Library.userService.getCurrentUser();
        if(user==null){
            System.out.println("Please login first.");
            return;
        }
        //cmd sample - list
        Library.userBookService.showBookList();
    }
}
