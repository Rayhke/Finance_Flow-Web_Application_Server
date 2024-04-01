package com.example.DataBase.repository;

import com.example.DataBase.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class MemberJpaRepository implements MemberRepository {

    private final EntityManager em;

    @Autowired
    public MemberJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public String save(Member member) {
        em.persist(member);
        return member.getId();
    }

    @Override
    public Member findById(String id) {
        return em.find(Member.class, id);
    }

    @Override
    public Member update(Member member) {
        Member result = em.find(Member.class, member.getId());
        result.update(member.getPwd());
        return result;
    }

    @Override
    public String delete(String id) {
        Member result = em.find(Member.class, id);
        em.remove(result);
        return id;
    }

    @Override
    public String deleteTest(Member member) {
        em.remove(member);
        return member.getId();
    }
}
