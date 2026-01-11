package com.file.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.file.manager.service.api.UserService;
import com.file.manager.entity.User;
import com.file.manager.mapper.UserMapper;
import com.github.benmanes.caffeine.cache.Cache;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    // 加密
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource(name = "dictCache")
    private Cache<String, Object> dictCache;


    @Override
    public int install(User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        int rows = userMapper.insert(user);
        return rows;
    }

//    @Override
//    public User getUser(String  username) {
//        // 1. 构建查询条件
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(User::getUsername,username); // SQL:WHERE USERNAME = ?
//        // 2. 执行查询 (selectOne 适用于 unique 字段)
//        User user = userMapper.selectOne(wrapper);
//        return user;
//    }

    @Override
    public User getUser(String  username) {
        Object cachedValue =dictCache.get(username,key ->{
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getUsername,username); // SQL:WHERE USERNAME = ?
            // 2. 执行查询
            System.out.println("缓存未命中，开始查库获取用户: " + key);
            User user = userMapper.selectOne(wrapper);
            return user;
        });
        return (User) cachedValue;
    }


}
