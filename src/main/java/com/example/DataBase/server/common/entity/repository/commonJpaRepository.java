package com.example.DataBase.server.common.entity.repository;

import com.example.DataBase.server.common.entity.commonEntityImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Optional;

/**
 * @param <T> Object Relational Mapping, Entity 객체
 * @param <ID> 위의 Entity 객체에서의 P.K 타입
 */
public abstract class commonJpaRepository<T, ID> extends commonEntityImpl<ID> implements commonRepository<T, ID> {

    @Override   // User / P.K : String
    public <S extends T> ID save(S entity) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(entity);
            tx.commit();

            return getId();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        return (ID) "purpose:fail/class:commonJpaRepository.java/method:save/reason:";
    }

    @Override
    public Optional<T> findById(ID id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            T entity = em.find(getEntityClass(), id);
            tx.commit();

            return Optional.ofNullable(entity);
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    /**
     * 현재 클래스 내에서 직접적으로 사용하지 않고,
     * 이 클래스를 하위 클래스가 @Override 재정의하여 사용
     */
    @Override
    public <S extends T> ID update(S entity) {
        return getId();
    }

    @Override
    public ID delete(ID id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            T entity = em.find(getEntityClass(), id);
            em.remove(entity);
            tx.commit();

            return id;
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return (ID) "purpose:fail/class:commonJpaRepository.java/method:delete/reason:";
    }

    protected abstract Class<T> getEntityClass();

    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    protected EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("mysql");
    }
}
