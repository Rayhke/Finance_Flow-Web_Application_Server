package com.example.DataBase.server.user.entity;

import com.example.DataBase.server.common.entity.commonEntityImpl;
import com.google.gson.JsonObject;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "users")
public class User extends commonEntityImpl {

    @Id
    @Column(name = "user_id", length = 50)
    private String id;

    @Column(name = "user_pwd", length = 50)
    private String pwd;

    @Column(name = "user_email", length = 100)
    private String email;

    public User(JsonObject json) {
        this.id = json.get("id").getAsString();
        this.pwd = json.get("pwd").getAsString();
        this.email = json.get("email").getAsString();
    }

    public void update(String pwd, String email) {
        this.pwd = pwd;
        this.email = email;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User[id = " + getId() + ", pwd = " + pwd + ", email = " + email + "]";
    }
}
