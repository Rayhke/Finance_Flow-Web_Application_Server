package com.example.DataBase.server.user.repository;

import com.example.DataBase.server.common.repository.commonJpaRepository;
import com.example.DataBase.unused.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserJpaRepository extends commonJpaRepository<User, String> {

    public String findByEmail(String pwd, String email) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            User result = em.createQuery("SELECT u FROM User u WHERE u.user_email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
            result.update(pwd, email);
            tx.commit();

            return result.getId();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return "purpose:fail/class:UserJpaRepository.java/method:findByEmail/reason:";

    }

    @Override
    public String update(User user) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            User result = em.find(User.class, user.getId());
            result.update(user.getPwd(), user.getEmail());
            tx.commit();

            return result.getId();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return "purpose:fail/class:UserJpaRepository.java/method:update/reason:";
    }

    public String login(String id, String pwd) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            User result = em.find(User.class, id);

            if (result.getPwd().equals(pwd)) { return "1"; }
            return "0";
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return "-1";
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}