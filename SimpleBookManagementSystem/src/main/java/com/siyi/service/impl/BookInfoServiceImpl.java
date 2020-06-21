package com.siyi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siyi.dao.BookInfoDAO;
import com.siyi.domain.BookInfo;
import com.siyi.vo.PageResult;
import com.siyi.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    private BookInfoDAO bookInfoDAO;

    /**
     * 根据查询条件分页查询
     * @param key
     * @param page
     * @param rows
     * @return
     */
    public PageResult<BookInfo> findAll(String key, Integer page, Integer rows) {
        List<BookInfo> books = null;
        if(key!=null && key.length()!=0){
            key="%"+key+"%";
            PageHelper.startPage(page,rows);
            books = bookInfoDAO.findAllByBookName(key);
        }else{
            PageHelper.startPage(page,rows);
            books = bookInfoDAO.findAll();
        }
        PageInfo<BookInfo> pageInfo = new PageInfo<BookInfo>(books);
        int pageTotal = (int)pageInfo.getTotal()/rows;
        if(pageInfo.getTotal()%rows!=0) pageTotal++;
        return new PageResult<BookInfo>((int)pageInfo.getTotal(),pageTotal,books);
    }

    public BookInfo findBookById(Long id) {
        return bookInfoDAO.findBookById(id);
    }

    public int addBook(BookInfo book) {
        book.setCreateTime(new Date());
        book.setNumber(book.getTotal());
        return bookInfoDAO.saveBookInfo(book);
    }

    public int updateBook(BookInfo book) {
        BookInfo bookById = bookInfoDAO.findBookById(book.getBookId());
        long pos = book.getTotal() - bookById.getTotal();
        book.setNumber(bookById.getNumber()+pos);
        book.setCreateTime(bookById.getCreateTime());
        return bookInfoDAO.updateBookInfoById(book);
    }

    public int deleteById(Long id) {
        return bookInfoDAO.deleteBookInfoById(id);
    }

    public boolean deleteByIdArray(String[] ids) {
        for (String id: ids) {
            int i = bookInfoDAO.deleteBookInfoById(Long.parseLong(id));
            if(i!=1) return false;
        }
        return true;
    }
}
