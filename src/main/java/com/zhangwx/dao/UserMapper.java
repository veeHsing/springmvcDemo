package com.zhangwx.dao;

import com.zhangwx.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user ")
    public User findById();

    @Insert("insert into user (username,password) values (#{username},#{password}) ")
    public void insert(User user);

}
