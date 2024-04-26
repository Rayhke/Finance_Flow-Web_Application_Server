package com.example.DataBase.unused.repository;

import com.example.DataBase.unused.entity.User;

public interface UserRepository {

    String save(User user); // 회원가입

    User findById(String id); // 로그인

    User update(User user);   // 회원정보 수정 (password, email)

    String delete(String id);       // 회원탈퇴

    String deleteTest(User user);
}
