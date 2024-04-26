package com.example.DataBase.service;

import com.example.DataBase.entity.User;

public interface UserService {

    String save(User user);

    User findById(String id);

    User update(User user);

    String delete(String id);
}