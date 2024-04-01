package com.example.DataBase.service;

import com.example.DataBase.entity.Member;
import com.example.DataBase.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member findById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member update(Member member) {
        return memberRepository.update(member);
    }

    @Override
    public String delete(String id) {
        return memberRepository.delete(id);
    }

    public String deleteTest(Member member) {
        return memberRepository.deleteTest(member);
    }
}
