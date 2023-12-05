package com.dbs.entity;

import java.util.List;

/**
 * @author Jason He
 * @date 2023/12/5 16:45
 */
public class Library {
    private List<Book> bookList;
    private  List<User> userList;

    public List<Book> getBookList() {
        return bookList;
    }

    public Library(List<Book> bookList, List<User> userList) {
        this.bookList = bookList;
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
