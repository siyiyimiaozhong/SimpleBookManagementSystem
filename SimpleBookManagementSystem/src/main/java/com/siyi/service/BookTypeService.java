package com.siyi.service;

import com.siyi.domain.BookType;

import java.lang.reflect.Type;
import java.util.List;

public interface BookTypeService {
    List<BookType> findAll();

    int addType(BookType type);

    int deleteById(Long id);

    boolean deleteByIdArray(String[] ids);
}
