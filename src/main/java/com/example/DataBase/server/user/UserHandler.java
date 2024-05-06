package com.example.DataBase.server.user;

import com.example.DataBase.server.user.entity.User;

public interface UserHandler {

    User selectDBMS(String mode, User user);
}
