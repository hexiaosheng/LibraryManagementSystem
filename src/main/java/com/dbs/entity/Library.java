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
    private List<Book> bookList;
    private List<User> userList;
    public static UserService userService;
    public static AdminBookService adminBookService;
    public static UserBookService userBookService;

    public Library() {
        this.bookList = new ArrayList<Book>();
        this.userList = new ArrayList<User>();

        userService=new UserService(userList);
        adminBookService=new AdminBookService(bookList);
        userBookService=new UserBookService(bookList);
    }
    public List<User> getUserList() {
        return userList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
