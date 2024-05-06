package com.example.DataBase.server.user.repository;

import com.example.DataBase.server.user.entity.User;

public interface UserRepository {

    User findById(String id);
}
