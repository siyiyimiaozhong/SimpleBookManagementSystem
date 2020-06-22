package com.siyi.service.impl;

import com.siyi.dao.BookInfoDAO;
import com.siyi.dao.BookTypeDAO;
import com.siyi.dao.BorrowDAO;
import com.siyi.dao.ReaderInfoDAO;
import com.siyi.domain.BookInfo;
import com.siyi.domain.Borrow;
import com.siyi.domain.ReaderInfo;
import com.siyi.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowDAO borrowDAO;
    @Autowired
    private BookInfoDAO bookInfoDAO;
    @Autowired
    private ReaderInfoDAO readerInfoDAO;

    /**
     * 根据条件查询所有逾期的记录
     * @param key
     * @param value
     * @return
     */
    public List<Borrow> findAllByOverdue(String key, String value) {
        List<Borrow> borrows=null;
        if(value==null || value.length()==0){
            borrows = borrowDAO.findNotReturn();
        }else{
            value="%"+value+"%";
            List<Long> ids=null;
            if(key.equals("bookName")){
                key="book_id";
                List<BookInfo> books = bookInfoDAO.findAllByBookName(value);
                 ids = books.stream().map(bookInfo -> {
                    return bookInfo.getBookId();
                }).collect(Collectors.toList());
            }else{
                key="reader_id";
                List<ReaderInfo> readers = readerInfoDAO.findReadersByKey(value);
                ids = readers.stream().map(readerInfo -> {
                    return readerInfo.getReaderId();
                }).collect(Collectors.toList());
            }
            borrows = borrowDAO.findNotReturnByKeyAndValue(key,ids);
        }
        List<Borrow> borrowList = new ArrayList<Borrow>();
        for(Borrow borrow:borrows){
            long time = new Date().getTime();
            if((time-borrow.getLendDate().getTime())>=(long)(30L*24*60*60*1000)){
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    /**
     * 根据指定id添加还书时间
     * @param id
     * @return
     */
    @Override
    public int updateBackDate(String id) {
        Borrow borrow = new Borrow();
        borrow.setBorrowId(id);
        borrow.setBackDate(new Date());
        return borrowDAO.updateBorrowBackDate(borrow);
    }

    /**
     * 批量添加还书时间
     * @param idArray
     * @return
     */
    @Override
    public boolean updateBackDateByIds(String[] idArray) {
        Borrow borrow = new Borrow();
        for(String id:idArray){
            borrow.setBorrowId(id);
            borrow.setBackDate(new Date());
            int i = borrowDAO.updateBorrowBackDate(borrow);
            if(i!=1) return false;
        }
        return true;
    }
}
