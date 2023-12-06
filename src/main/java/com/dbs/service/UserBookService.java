package com.dbs.service;

import com.dbs.entity.Book;

import java.util.List;

/**
 * @author Jason He
 * @date 2023/12/5 16:57
 */
public class UserBookService extends BookService{

    private List<Book> bookList;
    public UserBookService(List<Book> bookList) {
        super(bookList);
    }

    public void borrowBook(String bookName,String bookAuthor){
        //parameter validation
        if(bookName==null || bookName.isEmpty()) {
            System.out.println("Book name can't be empty!");
            return;
        }
        if(bookAuthor==null || bookAuthor.isEmpty()) {
            System.out.println("Book Author can't be empty!");
            return;
        }
        //borrow the book from the library
        boolean blnFound=false;
        for(Book book:bookList){
            if(book.getBookName().equalsIgnoreCase(bookName)
                    && book.getBookAuthor().equalsIgnoreCase(bookAuthor)){
                blnFound=true;
                //check the book if has been booked
                if(book.isBorrowed()){
                    System.out.println(String.format("Book %s has been borrowed.",bookName));
                }else{
                    book.setBorrowed(true);
                    System.out.println(String.format("Book %s successfully borrowed.",bookName));
                }
            }
        }
        if(blnFound==false){
            System.out.println("No such book for borrow.");
        }
    }

    public void returnBook(String bookName,String bookAuthor){
        //parameter validation
        if(bookName==null || bookName.isEmpty()) {
            System.out.println("Book name can't be empty!");
            return;
        }
        if(bookAuthor==null || bookAuthor.isEmpty()) {
            System.out.println("Book Author can't be empty!");
            return;
        }
        //return the book to library
        boolean blnFound=false;
        for(Book book:bookList){
            if(book.getBookName().equalsIgnoreCase(bookName)
                    && book.getBookAuthor().equalsIgnoreCase(bookAuthor)){
                blnFound=true;
                //check the book if has been borrowed
                if(book.isBorrowed()){
                    book.setBorrowed(false);
                    System.out.println(String.format("Book %s successfully returned.",bookName));
                }else{
                    System.out.println(String.format("Book %s is already returned.",bookName));
                }
            }
        }
        if(blnFound==false){
            System.out.println("No such book for return.");
        }

    }
}
