package com.dbs.service;

import com.dbs.entity.Book;

import java.util.List;

/**
 * @author Jason He
 * @date 2023/12/5 16:59
 */
public class AdminBookService extends BookService {

    public AdminBookService(List<Book> bookList) {
        super(bookList);
    }

    public void  deleteBook(String bookName,String bookAuthor){

    }

    public void  addBook(String bookName,String bookAuthor){

    }

}
