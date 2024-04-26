package com.example.DataBase.server.entity;


public abstract class commonEntityImpl<ID> implements commonEntity<ID> {

    private ID id;

    @Override
    public ID getId() {
        return id;
    }
}
