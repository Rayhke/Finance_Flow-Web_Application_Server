package com.example.DataBase.unused.repository;

import com.example.DataBase.unused.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class UserJpaRepository implements UserRepository {

    private final EntityManager em;

    @Autowired
    public UserJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public String save(User user) {
        em.persist(user);
        return user.getId();
    }

    @Override
    public User findById(String id) {
        return em.find(User.class, id);
    }

    @Override
    public User update(User user) {
        User result = em.find(User.class, user.getId());
        result.update(user.getPwd(), user.getEmail());
        return result;
    }

    @Override
    public String delete(String id) {
        User result = em.find(User.class, id);
        em.remove(result);
        return id;
    }

    @Override
    public String deleteTest(User user) {
        em.remove(user);
        return user.getId();
    }
}
