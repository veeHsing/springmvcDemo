package com.zhangwx.service;

import com.zhangwx.model.User;

public interface UserService {

    public User findAll();

    public void Insert(User user);
}
