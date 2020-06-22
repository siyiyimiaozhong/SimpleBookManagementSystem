package com.siyi.dao;

import com.siyi.domain.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BorrowDAO {
    @Select("select * from borrow")
    @Results(id = "borrow",value = {
            @Result(id = true,property = "borrowId",column = "borrow_id"),
            @Result(property = "lendDate",column = "lend_date"),
            @Result(property = "backDate",column = "back_date"),
            @Result(property = "bookName",column = "book_id",one = @One(select = "com.siyi.dao.BookInfoDAO.findBookNameById")),
            @Result(property = "readerName",column = "reader_id",one = @One(select = "com.siyi.dao.ReaderInfoDAO.findReaderNameById"))
    })
    public List<Borrow> findAll();

    @Select("select * from borrow where back_date is not null order by lend_date desc")
    public List<Borrow> findReturned();

    @Select("select * from borrow where back_date is null order by lend_date desc")
    @ResultMap("borrow")
    public List<Borrow> findNotReturn();

    @Select("select * from borrow where back_date is not null and reader_id=#{readerId}")
    public List<Borrow> findNotReturnByReaderId(@Param("readerId") Long readerId);

    @Insert("insert into borrow(borrow_id,book_id,reader_id,lend_date) " +
            "value(#{borrowId},#{bookId},#{readerId},#{lendDate})")
    public int saveBorrow(Borrow borrow);

    @Update("update borrow set back_date=#{backDate} where borrow_id=#{borrowId}")
    public int updateBorrowBackDate(Borrow borrow);

    @Select("<script>"
            + "select * from `borrow` where back_date is null and ${key} in "
            + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + " order by lend_date desc"
            + "</script>")
    @ResultMap("borrow")
    List<Borrow> findNotReturnByKeyAndValue(@Param("key") String key,@Param("ids") List<Long> ids);

    @Select("<script>"
            + "select * from `borrow` where ${key} in "
            + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + " order by lend_date desc"
            + "</script>")
    @ResultMap("borrow")
    List<Borrow> findAllByKeyAndValue(String key, List<Long> ids);
}
