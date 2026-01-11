package com.file.manager.controller;

import com.file.manager.entity.User;
import com.file.manager.service.api.UserService;

import com.file.manager.utils.Result;
import com.file.manager.utils.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public Result<User> getInfo(String username) {
        Optional<User> userOpt = Optional.ofNullable(userService.getUser(username));
        return userOpt
                .map(user -> Result.success(user))
                .orElseGet(()->Result.error(ResultCode.NOT_FOUND));


    }

    // 注册接口
    @PostMapping("/register")
    public Result<Integer> saveUser(@RequestBody User user){
        int row = userService.install(user);
        return Result.success(row);
    }
}
