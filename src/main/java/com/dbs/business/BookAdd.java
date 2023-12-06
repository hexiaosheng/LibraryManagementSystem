package com.dbs.business;

import com.dbs.entity.Library;

/**
 * @author Jason He
 * @date 2023/12/6 17:18
 */
public class BookAdd extends Business {
    @Override
    public void Process() {
        //cmd sample - add "Clean Code" "Robert C. Martin" 5
        String bookName=BusinessParameters[1];
        String bookAuthor=BusinessParameters[2];
        Integer bookInventory= Integer.parseInt(BusinessParameters[3]);

        Library.adminBookService.addBook(bookName,bookAuthor,bookInventory);
    }
}
