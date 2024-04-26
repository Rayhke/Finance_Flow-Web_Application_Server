package com.example.DataBase.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity extends commonEntityImpl {

    @Id
    @Column(name = "user_id", length = 50)
    private String id;

    @Column(name = "user_pwd", length = 50)
    private String pwd;

    @Column(name = "user_email", length = 100)
    private String email;
}
