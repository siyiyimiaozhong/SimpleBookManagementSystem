package com.siyi.dao;

import com.siyi.domain.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BorrowDAO {
    @Select("select * from borrow")
    public List<Borrow> findAll();

    @Select("select * from borrow where back_date is not null")
    public List<Borrow> findReturned();

    @Select("select * from borrow where back_date is null")
    public List<Borrow> findNotReturn();

    @Select("select * from borrow where back_date is not null and reader_id=#{readerId}")
    public List<Borrow> findNotReturnByReaderId(@Param("readerId") Long readerId);

    @Insert("insert into borrow(borrow_id,book_id,reader_id,lend_date) " +
            "value(#{borrowId},#{bookId},#{readerId},#{lendDate})")
    public int saveBorrow(Borrow borrow);

    @Update("update borrow set back_date=#{backDate} where borrow_id=#{borrowId}")
    public int updateBorrowBackDate(Borrow borrow);
}
