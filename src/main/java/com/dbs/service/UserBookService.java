package com.dbs.service;

import com.dbs.entity.Book;

import java.util.List;

/**
 * @author Jason He
 * @date 2023/12/5 16:57
 */
public class UserBookService extends BookService{
    public UserBookService(List<Book> bookList) {
        super(bookList);
    }

    public void borrowBook(String bookName,String bookAuthor){

    }

    public void returnBook(String bookName,String bookAuthor){

    }
}
