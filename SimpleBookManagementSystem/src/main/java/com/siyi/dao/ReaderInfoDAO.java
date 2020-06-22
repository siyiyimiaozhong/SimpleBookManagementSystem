package com.siyi.dao;

import com.siyi.domain.ReaderInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReaderInfoDAO {
    @Select("select * from reader_info order by create_time desc")
    @Results(id = "readerInfo",value = {
            @Result(id = true,property = "readerId",column = "reader_id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birth",column = "birth"),
            @Result(property = "address",column = "address"),
            @Result(property = "borrowCount",column = "borrow_count"),
            @Result(property = "createTime",column = "create_time")
    })
    public List<ReaderInfo> findAll();

    @Delete("delete from reader_info where reader_id=#{id}")
    public int deleteReaderById(@Param("id")Long id);

    @Insert("insert into reader_info(name,sex,birth,address,phone,borrow_count,username,password,create_time) " +
            "value(#{name},#{sex},#{birth},#{address},#{phone},#{borrowCount},#{username},#{password},#{createTime})")
    public int saveReader(ReaderInfo readerInfo);

    @Update("update reader_info name=#{name},sex=#{sex},birth=#{birth},address=#{address},phone=#{phone},borrow_count=#{borrowCount},username=#{username},password=#{password} where borrow_id=#{borrowId}")
    public int updateReader(ReaderInfo readerInfo);

    @Select("select * from reader_info where username=#{username}")
    public ReaderInfo findReaderByUsername(String username);

    @Select("select * from reader_info where name like #{key} order by create_time desc")
    @ResultMap("readerInfo")
    List<ReaderInfo> findReadersByKey(@Param("key") String key);

    @Select("select * from reader_info where reader_id=#{id}")
    ReaderInfo findReaderById(@Param("id") Long id);

    @Select("select name from reader_info where reader_id=#{id}")
    public String findReaderNameById(@Param("id") Long id);
}
