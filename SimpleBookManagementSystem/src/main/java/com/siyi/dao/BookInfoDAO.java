package com.siyi.dao;

import com.siyi.domain.BookInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookInfoDAO {

    @Select("select * from book_info order by create_time desc")
    @Results(id="bookInfo",value = {
            @Result(id=true,property = "bookId",column = "book_id"),
            @Result(property = "name",column = "name"),
            @Result(property = "author",column = "author"),
            @Result(property = "publish",column = "publish"),
            @Result(property = "ISBN",column = "ISBN"),
            @Result(property = "introduction",column = "introduction"),
            @Result(property = "language",column = "language"),
            @Result(property = "price",column = "price"),
            @Result(property = "pubDate",column = "pub_date"),
            @Result(property = "number",column = "number"),
            @Result(property = "total",column = "total"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "type",column = "type_id",one = @One(select = "com.siyi.dao.BookTypeDAO.findTypeNameById"))
    })
    public List<BookInfo> findAll();

    @Update("update book_info set name=#{name},author=#{author},publish=#{publish},ISBN=#{ISBN},introduction=#{introduction},`language`=#{language},price=#{price},pub_date=#{pubDate},type_id=#{type},number=#{number},total=#{total},create_time=#{createTime} where book_id=#{bookId}")
    public int updateBookInfoById(BookInfo bookInfo);

    @Insert("insert into book_info(name,author,publish,ISBN,introduction,`language`,price,pub_date,type_id,number,total,create_time) " +
            "VALUE(#{name},#{author},#{publish},#{ISBN},#{introduction},#{language},#{price},#{pubDate},#{type},#{number},#{total},#{createTime})")
    public int saveBookInfo(BookInfo bookInfo);

    @Delete("delete from book_info where book_id=#{id}")
    public int deleteBookInfoById(@Param("id") Long id);

    @Select("select * from book_info where name like #{key}")
    @ResultMap("bookInfo")
    public List<BookInfo> findAllByBookName(@Param("key") String key);

    @Select("select * from book_info where book_id=#{id}")
    @ResultMap("bookInfo")
    public BookInfo findBookById(@Param("id") Long id);

    @Select("select name from book_info where book_id=#{id}")
    public String findBookNameById(@Param("id")Long id);
}
