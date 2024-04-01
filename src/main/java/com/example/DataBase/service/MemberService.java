package com.example.DataBase.service;

import com.example.DataBase.entity.Member;

public interface MemberService {

    String save(Member member);

    Member findById(String id);

    Member update(Member member);

    String delete(String id);
}