package com.example.DataBase.server.common.entity.transmitter;

import com.example.DataBase.unused.entity.User;

public interface UserSocketTransmitter {

    String save(User user);

    String findByEmail(String pwd, String email);

    String update(User user);

    String delete(String id);
}
