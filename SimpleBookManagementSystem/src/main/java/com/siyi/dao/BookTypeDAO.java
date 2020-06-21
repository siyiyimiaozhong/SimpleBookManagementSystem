package com.siyi.dao;

import com.siyi.domain.BookType;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookTypeDAO {
    @Select("select * from book_type")
    @Results(id = "bookType",value = {
            @Result(id = true,property = "typeId",column = "type_id"),
            @Result(property = "typeName",column = "type_name")
    })
    public List<BookType> findAll();

    @Insert("insert into book_type(type_name) value(#{typeName})")
    public int saveBookType(BookType bookType);

    @Delete("delete from book_type where type_id=#{id}")
    public int deleteBookTypeById(@Param("id") Long id);

    @Update("update book_type set type_name=#{typeName} where type_id=#{typeId}")
    public int updateBookType();

    @Select("select type_name from book_type where type_id=#{id}")
    public String findTypeNameById(@Param("id") Long id);
}
