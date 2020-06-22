package com.siyi.dao;

import com.siyi.domain.Admin;
import org.apache.ibatis.annotations.*;

public interface AdminDAO {

    @Select("select * from admin where username=#{username}")
    @Results(id = "admin",value = {
            @Result(id = true,property = "adminId",column = "admin_id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password")
    })
    public Admin findAdminByUsername(@Param("username") String username);

    @Select("select password from admin where admin_id=#{id}")
    public String findPasswordById(@Param("id") Long id);

    @Update("update admin set password=#{password} where admin_id=#{id}")
    Integer updatePW(@Param("id") Long id,@Param("password") String password);
}
