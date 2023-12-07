package com.dbs.entity;

import com.dbs.service.AdminBookService;
import com.dbs.service.UserBookService;
import com.dbs.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason He
 * @date 2023/12/5 16:45
 */
public class Library {
    public static UserService userService;
    public static AdminBookService adminBookService;
    public static UserBookService userBookService;

    public Library() {
        List<Book> bookList = new ArrayList<Book>();
        List<User> userList = new ArrayList<User>();

        userService=new UserService(userList);
        adminBookService=new AdminBookService(bookList);
        userBookService=new UserBookService(bookList);
    }
}
