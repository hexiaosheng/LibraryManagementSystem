package com.dbs.business;

import com.dbs.entity.Library;
import com.dbs.entity.User;

/**
 * @author Jason He
 * @date 2023/12/6 17:18
 */
public class BookDelete extends Business {
    @Override
    public void Process() {
        //check user role, only admin can delete book from library
        User user=Library.userService.getCurrentUser();
        if(user==null || user.getUserRole()!= User.UserType.admin){
            System.out.println("Please login in admin.");
            return;
        }
        //cmd sample -delete "Clean Code" "Robert C. Martin"
        String bookName=BusinessParameters[1];
        String bookAuthor=BusinessParameters[2];

        Library.adminBookService.deleteBook(bookName,bookAuthor);
    }
}
