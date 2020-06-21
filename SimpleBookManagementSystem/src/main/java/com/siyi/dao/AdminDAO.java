package com.siyi.dao;

import com.siyi.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminDAO {

    @Select("select * from admin where username=#{username}")
    public Admin findAdminByUsername(@Param("username") String username);
}
