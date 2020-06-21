package com.siyi.service.impl;

import com.siyi.dao.BookTypeDAO;
import com.siyi.domain.BookType;
import com.siyi.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    private BookTypeDAO bookTypeDAO;

    public List<BookType> findAll() {
        return bookTypeDAO.findAll();
    }
}
