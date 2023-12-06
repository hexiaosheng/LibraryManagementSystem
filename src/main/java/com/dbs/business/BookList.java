package com.dbs.business;

import com.dbs.entity.Library;

/**
 * @author Jason He
 * @date 2023/12/6 17:18
 */
public class BookList extends Business{
    @Override
    public void Process() {
        //cmd sample - list
        Library.userBookService.showBookList();
    }
}
