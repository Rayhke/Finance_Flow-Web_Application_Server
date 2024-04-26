package com.example.DataBase.server.repository;

import com.example.DataBase.entity.User;

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

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}