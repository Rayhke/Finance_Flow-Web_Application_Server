package com.example.DataBase.controller;

import com.example.DataBase.entity.User;
import com.example.DataBase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String userInsert(User user) {
        return userService.save(user);
    }

    public void check(String mode, User user) {
        switch (mode) {
            case "insert":
                userInsert(user); break;
        }
    }
}