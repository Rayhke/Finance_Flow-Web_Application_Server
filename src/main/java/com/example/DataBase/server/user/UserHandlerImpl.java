package com.example.DataBase.server.user;

import com.example.DataBase.server.user.entity.User;
import com.example.DataBase.server.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserHandlerImpl implements UserHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserHandlerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User selectDBMS(String mode, User user) {
        switch (mode) {
            case "save":
                // return userRepository;
            case "findById":
                return userRepository.findById(user.getId());

        }
        return null;
    }

    /*public UserHandler(User user) {
        this.user = user;
        userJpaRepository = new UserJpaRepository();
    }*/




    /*public JsonObject findMode() {

    }*/
}
