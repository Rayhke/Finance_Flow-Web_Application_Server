package com.example.DataBase.server.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface commonRepository<T, ID> extends Repository<T, ID> {

    <S extends T> ID save(S entity);

    Optional<T> findById(ID id);

    <S extends T> ID update(S entity);

    ID delete(ID id);
}
