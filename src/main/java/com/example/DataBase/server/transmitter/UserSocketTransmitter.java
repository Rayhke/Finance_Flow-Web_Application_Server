package com.example.DataBase.server.transmitter;

import com.example.DataBase.entity.User;

public interface UserSocketTransmitter {

    String save(User user);

    String findByEmail(String pwd, String email);

    String update(User user);

    String delete(String id);
}
