package com.example.DataBase.unused.service;

import com.example.DataBase.unused.entity.User;

public interface UserService {

    String save(User user);

    User findById(String id);

    User update(User user);

    String delete(String id);
}