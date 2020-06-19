package com.siyi.dao;

import com.siyi.domain.BookInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookInfoDAO {

    @Select("select * from book_info")
    public List<BookInfo> findAll();

    @Update("update book_info set name=#{name},author=#{author},publish=#{publish},ISBN=#{ISBN},introduction=#{introduction},`language`=#{language},price=#{price},pub_date=#{pubDate},type_id=#{typeId},number=#{number} where book_id=#{bookId}")
    public int updateBookInfoById(BookInfo bookInfo);

    @Insert("insert into book_info(name,author,publish,ISBN,introduction,`language`,price,pub_date,type_id,number) " +
            "VALUE(#{name},#{author},#{publish},#{ISBN},#{introduction},#{language},#{price},#{pubDate},#{typeId},#{number})")
    public int saveBookInfo(BookInfo bookInfo);

    @Delete("delete from book_info where book_id=#{id}")
    public int deleteBookInfoById(@Param("id") Long id);
}
