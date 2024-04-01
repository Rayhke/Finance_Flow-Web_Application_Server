package com.example.DataBase;

import com.example.DataBase.repository.MemberJpaRepository;
import com.example.DataBase.repository.MemberRepository;
import com.example.DataBase.service.MemberService;
import com.example.DataBase.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class Config {

    private final EntityManager em;

    @Autowired
    public Config(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberJpaRepository(em);
    }
}
