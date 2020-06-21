package com.siyi.dao;

import com.siyi.domain.ReaderInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReaderInfoDAO {
    @Select("select * from reader_info")
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

}
