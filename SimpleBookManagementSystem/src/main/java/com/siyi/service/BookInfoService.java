package com.siyi.service;

import com.siyi.domain.BookInfo;
import com.siyi.vo.PageResult;

public interface BookInfoService {
    PageResult<BookInfo> findAll(String key, Integer page, Integer rows);

    BookInfo findBookById(Long id);

    int addBook(BookInfo book);

    int updateBook(BookInfo book);

    int deleteById(Long id);

    boolean deleteByIdArray(String[] ids);

    PageResult<BookInfo> findAllByNumber(String key, Integer page, Integer rows);

    int borrow(Long id);
}
