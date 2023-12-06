package com.dbs.service;

import com.dbs.entity.Book;
import com.dbs.entity.Library;

import java.util.List;

/**
 * @author Jason He
 * @date 2023/12/5 16:39
 */
public class BookService {
    private List<Book> bookList;
    public BookService(List<Book> bookList) {
        this.bookList = bookList;
    }
    public void showBookList(){
        System.out.println("Book List:\n");
        for(Book book:bookList){
            System.out.println(String.format("%s - %s  - Inventory: %d",book.getBookName(),
                    book.getBookAuthor(),book.getBookInventory())+"\n");
        }
    }
}
