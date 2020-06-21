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

    public int addType(BookType type) {
        return bookTypeDAO.saveBookType(type);
    }

    public int deleteById(Long id) {
        return bookTypeDAO.deleteBookTypeById(id);
    }

    public boolean deleteByIdArray(String[] ids) {
        for (String id: ids) {
            int i = bookTypeDAO.deleteBookTypeById(Long.parseLong(id));
            if(i!=1) return false;
        }
        return true;
    }
}
