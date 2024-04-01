package com.example.DataBase.repository;

import com.example.DataBase.entity.Member;

public interface MemberRepository {

    String save(Member member); // 회원가입

    Member findById(String id); // 로그인

    Member update(Member member);   // 회원정보 수정

    String delete(String id);       // 회원탈퇴

    String deleteTest(Member member);
}
