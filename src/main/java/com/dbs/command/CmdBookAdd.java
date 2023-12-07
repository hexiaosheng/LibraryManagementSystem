package com.dbs.command;

import com.dbs.entity.Library;
import com.dbs.entity.User;

/**
 * @author Jason He
 * @date 2023/12/6 17:18
 */
public class CmdBookAdd extends Command {
    @Override
    public void Process() {
        //check user role, only admin can add book to library
        User user=Library.userService.getCurrentUser();
        if(user==null || user.getUserRole()!= User.UserType.admin){
            System.out.println("Please login in admin.");
            return;
        }
        //cmd sample - add "Clean Code" "Robert C. Martin" 5
        String bookName=Parameters[1];
        String bookAuthor=Parameters[2];
        Integer bookInventory= Integer.parseInt(Parameters[3]);

        Library.adminBookService.addBook(bookName,bookAuthor,bookInventory);
    }
}
