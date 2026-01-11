package com.file.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.file.manager.entity.User;
import com.file.manager.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            // 1. 去数据库查用户 (使用 MyBatis-Plus)
            User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                    .eq(User::getUsername, username)
                    .select(User::getUsername,User::getPasswordHash)
            );

            // 2. 如果没查到，抛出异常
            if (user == null) {
                throw new UsernameNotFoundException("用户不存在: " + username);
            }

            // 3. 返回 Spring Security 需要的 User 对象
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPasswordHash())
                    .roles("USER") // 暂时给个默认角色
                    .build();


    }
}
