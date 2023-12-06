package com.dbs.business;

import com.dbs.entity.Library;

/**
 * @author Jason He
 * @date 2023/12/6 17:18
 */
public class BookReturn extends Business {
    @Override
    public void Process() {
        //cmd sample - return "Clean Code" " Robert C. Martin"
        String bookName=BusinessParameters[1];
        String bookAuthor=BusinessParameters[2];

        Library.userBookService.returnBook(bookName,bookAuthor);
    }
}
