package com.dbs.entity;

import java.util.UUID;

/**
 * @author Jason He
 * @date 2023/12/5 16:07
 */
public class Book {
    private String bookID;
    private String bookName;
    private String bookAuthor;
    private Integer bookInventory;
    private boolean isBorrowed;

    public Book(String bookName, String bookAuthor, Integer bookInventory) {
        this.bookID = UUID.randomUUID().toString();
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookInventory = bookInventory;
    }

    public String getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(Integer bookInventory) {
        this.bookInventory = bookInventory;
    }
}
