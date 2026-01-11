package com.file.manager.service.api;


import com.file.manager.entity.User;

public interface UserService {

    int install(User user);

    User getUser(String username);
}
