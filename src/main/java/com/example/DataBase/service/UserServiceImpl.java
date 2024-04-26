package com.example.DataBase.service;

import com.example.DataBase.entity.User;
import com.example.DataBase.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public String delete(String id) {
        return userRepository.delete(id);
    }

    public String deleteTest(User user) {
        return userRepository.deleteTest(user);
    }
}
