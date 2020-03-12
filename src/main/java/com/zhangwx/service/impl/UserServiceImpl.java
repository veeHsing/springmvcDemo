package com.zhangwx.service.impl;

import com.zhangwx.dao.UserMapper;
import com.zhangwx.exception.SysException;
import com.zhangwx.model.User;
import com.zhangwx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findAll() {
        User user = userMapper.findById();
        return user;
    }

    @Override
    public void Insert(User user) {
        userMapper.insert(user);
    }
}
