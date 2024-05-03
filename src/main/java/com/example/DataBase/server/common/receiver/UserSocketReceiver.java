package com.example.DataBase.server.common.receiver;

import com.example.DataBase.server.user.User;

public interface UserSocketReceiver {

    String selectMode(String mode, User user);

    String save(User user);

    String findByEmail(String pwd, String email);

    String update(User user);

    String delete(String id);
}