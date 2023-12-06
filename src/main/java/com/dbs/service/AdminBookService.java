package com.dbs.service;

import com.dbs.entity.Book;

import java.util.List;

/**
 * @author Jason He
 * @date 2023/12/5 16:59
 */
public class AdminBookService extends BookService {
    private List<Book> bookList;
    public AdminBookService(List<Book> bookList) {
        super(bookList);
    }

    public void  deleteBook(String bookName,String bookAuthor){
        //parameter validation
        if(bookName==null || bookName.isEmpty()) {
            System.out.println("Book name can't be empty!");
            return;
        }
        if(bookAuthor==null || bookAuthor.isEmpty()) {
            System.out.println("Book author can't be empty!");
            return;
        }
        //delete the book from the library book list
        boolean blnFound=false;
        for(Book book:bookList){
            if(book.getBookName().equalsIgnoreCase(bookName)
                    && book.getBookAuthor().equalsIgnoreCase(bookAuthor)){
                blnFound=true;
                //check the book if has been booked
                if(book.isBorrowed()){
                    System.out.println(String.format("Cannot delete book %s because it is currently borrowed.",bookName));
                }else{
                    bookList.remove(book);
                }
            }
        }
        if(blnFound==false){
            System.out.println("No such book for deletion.");
        }
    }

    public void  addBook(String bookName,String bookAuthor,Integer bookInventory){
        //parameter validation
        if(bookName==null || bookName.isEmpty()) {
            System.out.println("Book name can't be empty!");
            return;
        }
        if(bookAuthor==null || bookAuthor.isEmpty()) {
            System.out.println("Book author can't be empty!");
            return;
        }
        if(bookInventory==null || bookInventory<=0) {
            System.out.println("Book inventory must larger than 0!");
            return;
        }
        //check if have the same book, if yes, merge the inventory
        Book newBook=new Book(bookName,bookAuthor,bookInventory);
        for(Book book:bookList){
            if(book.getBookName().equalsIgnoreCase(bookName)
                    && book.getBookAuthor().equalsIgnoreCase(bookAuthor)){
                newBook.setBookInventory(book.getBookInventory()+bookInventory);
                System.out.println(String.format("Book %s inventory successfully updated, new inventory: %d",book.getBookName(),
                        book.getBookInventory())+"\n");
            }else {
                System.out.println(String.format("Book %s by %s add successfully, Inventory: %d",book.getBookName(),
                        book.getBookAuthor(),book.getBookInventory())+"\n");
            }
        }
        //add new book to library book list
        bookList.add(newBook);
    }

}
