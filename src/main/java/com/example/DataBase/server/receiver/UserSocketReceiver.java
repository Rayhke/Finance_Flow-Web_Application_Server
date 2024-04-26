package com.example.DataBase.server.receiver;

import com.example.DataBase.unused.entity.User;

public interface UserSocketReceiver {

    String selectMode(String mode, User user);

    String save(User user);

    String findByEmail(String pwd, String email);

    String update(User user);

    String delete(String id);
}